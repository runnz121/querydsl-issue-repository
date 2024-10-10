package spring.example.test.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.example.test.domain.QSampleData;
import spring.example.test.domain.QSampleEntity2;
import spring.example.test.domain.SampleData;
import spring.example.test.domain.SampleStatus;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static spring.example.test.domain.QSampleEntity2.sampleEntity2;
import static spring.example.test.domain.QSampleEntity3.sampleEntity3;

@Repository
@RequiredArgsConstructor
public class QueryRepositoryImpl implements QueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<SampleData> getSampleQuery() {


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
}
