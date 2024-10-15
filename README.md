# QueryDsl case-when then 구문에서 getExpressible() NPE 발생 이슈 문의

### 문의 이슈
- https://hibernate.atlassian.net/browse/HHH-18681?focusedCommentId=116927

### 내용
- springBoot 3.3.0 // hibernate 6.5.2 에서 문제 없이 돌던 쿼리가 springboot 3.3.4 // hibernate 6.5.3 으로 버전 올릴시
```
  Cannot invoke "org.hibernate.query.sqm.SqmExpressible.getSqmType()" because the return value of "org.hibernate.query.sqm.tree.select.SqmSelection.getExpressible()" is null
```
에러 발생

### 트러블 슈팅
```
@Override
public SqmSubQuery<?> visitSubqueryExpression(HqlParser.SubqueryExpressionContext ctx) {
  return visitSubquery( (HqlParser.SubqueryContext) ctx.getChild( 1 ) );
}


@Override
public SqmSubQuery<?> visitSubquery(HqlParser.SubqueryContext ctx) {
    final HqlParser.QueryExpressionContext queryExpressionContext = ctx.queryExpression();
    final SqmSubQuery<?> subQuery = new SqmSubQuery<>(
          processingStateStack.getCurrent().getProcessingQuery(),
          creationContext.getNodeBuilder()
    );

    processingStateStack.push(
          new SqmQueryPartCreationProcessingStateStandardImpl(
                processingStateStack.getCurrent(),
                subQuery,
                this
          )
    );

    try {
       queryExpressionContext.accept( this );

       final List<SqmSelection<?>> selections = subQuery.getQuerySpec().getSelectClause().getSelections();
       if ( selections.size() == 1 ) {
          subQuery.applyInferableType( selections.get( 0 ).getExpressible().getSqmType() );
       }

       return subQuery;
    }
    finally {
       processingStateStack.pop();
    }
}
```
6.5.3 버전에서 selections.size() == 1 인 경우 if 문 조건을 타게되는데, 이때 SqmSubQuery 객체를 초기화하는 생성자 오버로딩부분에서 
```
SqmExpressible<T> expressibleType:
```
변수값을 초기화해주는 부분이 없음

```
public SqmSubQuery(
       SqmQuery<?> parent,
       NodeBuilder builder) {
    super( null, builder );
    this.parent = parent;
}
```

따라서 selections.size() == 1 이면 무조건 NPE 발생하는 구조

에러가 발생한 querydsl 구문은 다음과 같다.

```
 @Override
    public List<SampleData> getSampleQuery(String useDay, LocalDateTime todayKst) {

        return jpaQueryFactory
                .select(
                        new QSampleData(
                                Expressions.asString(caseBuilder(sampleEntity2))
                        )
                ).from(sampleEntity2)
                .fetch();
    }

    private StringExpression caseBuilder(QSampleEntity2 sampleEntity2) {
        CaseBuilder caseBuilder = new CaseBuilder();
        return caseBuilder.when(
                                      jpaQueryFactory
                                              .select(
                                                      new CaseBuilder()
                                                              .when(codeAsInt1(sampleEntity2.status).longValue().sum()
                                                                                                      .eq(sampleEntity3.count()))
                                                              .then(SampleStatus.SOLD_OUT.getCode())
                                                              .otherwise(SampleStatus.SALE.getCode())
                                              )
                                              .from(sampleEntity3)
                                              .ne(SampleStatus.SALE.getCode())
                              )
                              .then(SampleStatus.SOLD_OUT.getCode())
                              .otherwise(SampleStatus.SALE.getCode());
    }

    private NumberExpression<Integer> codeAsInt1(EnumPath<SampleStatus> enumPath) {
        return new CaseBuilder()
                .when(sampleStatus(enumPath))
                .then(1)
                .otherwise(0);
    }

    private BooleanExpression sampleStatus(EnumPath<SampleStatus> enumPath) {
        List<String> statusCodes = Arrays.asList(
                SampleStatus.SOLD_OUT.getCode()
        );
        return enumPath.stringValue().in(statusCodes);
    }
```

### 결과
- 이슈 해결됨으로 처리됨

<img width="476" alt="image" src="https://github.com/user-attachments/assets/f6802bb4-fcbb-49f7-ab27-3fb6dd7d5337">

