package spring.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.example.test.repository.QueryRepository;

@SpringBootTest
class TestApplicationTests {

	@Autowired
	QueryRepository queryRepository;


	// run this test code !!!
	@Test
	void repositoryTest() {
		queryRepository.getSampleQuery();
	}

	// error detail

	/**
	 * org.springframework.dao.InvalidDataAccessResourceUsageException: Error interpreting query [Cannot invoke "org.hibernate.query.sqm.SqmExpressible.getSqmType()" because the return value of "org.hibernate.query.sqm.tree.select.SqmSelection.getExpressible()" is null] [select case when ((select case when (sum(cast(case when (str(sampleEntity2.status) = ?1) then ?2 else ?3 end as long)) = count(sampleEntity3)) then ?4 else ?5 end
	 * from SampleEntity3 sampleEntity3) <> ?6) then ?7 else ?8 end
	 * from SampleEntity2 sampleEntity2] [select case when ((select case when (sum(cast(case when (str(sampleEntity2.status) = ?1) then ?2 else ?3 end as long)) = count(sampleEntity3)) then ?4 else ?5 end
	 * from SampleEntity3 sampleEntity3) <> ?6) then ?7 else ?8 end
	 * from SampleEntity2 sampleEntity2]
	 * 	at org.springframework.orm.jpa.vendor.HibernateJpaDialect.convertHibernateAccessException(HibernateJpaDialect.java:298)
	 * 	at org.springframework.orm.jpa.vendor.HibernateJpaDialect.translateExceptionIfPossible(HibernateJpaDialect.java:241)
	 * 	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.translateExceptionIfPossible(AbstractEntityManagerFactoryBean.java:550)
	 * 	at org.springframework.dao.support.ChainedPersistenceExceptionTranslator.translateExceptionIfPossible(ChainedPersistenceExceptionTranslator.java:61)
	 * 	at org.springframework.dao.support.DataAccessUtils.translateIfNecessary(DataAccessUtils.java:335)
	 * 	at org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:160)
	 * 	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
	 * 	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:768)
	 * 	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:720)
	 * 	at spring.example.test.repository.QueryRepositoryImpl$$SpringCGLIB$$0.getSampleQuery(<generated>)
	 * 	at spring.example.test.TestApplicationTests.repositoryTest(TestApplicationTests.java:17)
	 * 	at java.base/java.lang.reflect.Method.invoke(Method.java:569)
	 * 	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	 * 	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	 * Caused by: org.hibernate.query.sqm.InterpretationException: Error interpreting query [Cannot invoke "org.hibernate.query.sqm.SqmExpressible.getSqmType()" because the return value of "org.hibernate.query.sqm.tree.select.SqmSelection.getExpressible()" is null] [select case when ((select case when (sum(cast(case when (str(sampleEntity2.status) = ?1) then ?2 else ?3 end as long)) = count(sampleEntity3)) then ?4 else ?5 end
	 * from SampleEntity3 sampleEntity3) <> ?6) then ?7 else ?8 end
	 * from SampleEntity2 sampleEntity2] [select case when ((select case when (sum(cast(case when (str(sampleEntity2.status) = ?1) then ?2 else ?3 end as long)) = count(sampleEntity3)) then ?4 else ?5 end
	 * from SampleEntity3 sampleEntity3) <> ?6) then ?7 else ?8 end
	 * from SampleEntity2 sampleEntity2]
	 * 	at org.hibernate.query.hql.internal.StandardHqlTranslator.translate(StandardHqlTranslator.java:95)
	 * 	at org.hibernate.query.internal.QueryInterpretationCacheStandardImpl.createHqlInterpretation(QueryInterpretationCacheStandardImpl.java:145)
	 * 	at org.hibernate.query.internal.QueryInterpretationCacheStandardImpl.resolveHqlInterpretation(QueryInterpretationCacheStandardImpl.java:132)
	 * 	at org.hibernate.internal.AbstractSharedSessionContract.interpretHql(AbstractSharedSessionContract.java:802)
	 * 	at org.hibernate.internal.AbstractSharedSessionContract.createQuery(AbstractSharedSessionContract.java:852)
	 * 	at org.hibernate.internal.AbstractSharedSessionContract.createQuery(AbstractSharedSessionContract.java:765)
	 * 	at org.hibernate.internal.AbstractSharedSessionContract.createQuery(AbstractSharedSessionContract.java:140)
	 * 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	 * 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	 * 	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	 * 	at java.base/java.lang.reflect.Method.invoke(Method.java:569)
	 * 	at org.springframework.orm.jpa.ExtendedEntityManagerCreator$ExtendedEntityManagerInvocationHandler.invoke(ExtendedEntityManagerCreator.java:364)
	 * 	at jdk.proxy3/jdk.proxy3.$Proxy111.createQuery(Unknown Source)
	 * 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	 * 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	 * 	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	 * 	at java.base/java.lang.reflect.Method.invoke(Method.java:569)
	 * 	at org.springframework.orm.jpa.SharedEntityManagerCreator$SharedEntityManagerInvocationHandler.invoke(SharedEntityManagerCreator.java:319)
	 * 	at jdk.proxy3/jdk.proxy3.$Proxy111.createQuery(Unknown Source)
	 * 	at com.querydsl.jpa.impl.AbstractJPAQuery.createQuery(AbstractJPAQuery.java:132)
	 * 	at com.querydsl.jpa.impl.AbstractJPAQuery.createQuery(AbstractJPAQuery.java:125)
	 * 	at com.querydsl.jpa.impl.AbstractJPAQuery.fetch(AbstractJPAQuery.java:242)
	 * 	at spring.example.test.repository.QueryRepositoryImpl.getSampleQuery(QueryRepositoryImpl.java:41)
	 * 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	 * 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	 * 	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	 * 	at java.base/java.lang.reflect.Method.invoke(Method.java:569)
	 * 	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:355)
	 * 	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:196)
	 * 	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
	 * 	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:768)
	 * 	at org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:138)
	 * 	... 8 more
	 * Caused by: java.lang.NullPointerException: Cannot invoke "org.hibernate.query.sqm.SqmExpressible.getSqmType()" because the return value of "org.hibernate.query.sqm.tree.select.SqmSelection.getExpressible()" is null
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSubquery(SemanticQueryBuilder.java:5144)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSubqueryExpression(SemanticQueryBuilder.java:5120)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSubqueryExpression(SemanticQueryBuilder.java:275)
	 * 	at org.hibernate.grammars.hql.HqlParser$SubqueryExpressionContext.accept(HqlParser.java:7594)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.createComparisonPredicate(SemanticQueryBuilder.java:2543)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitComparisonPredicate(SemanticQueryBuilder.java:2504)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitComparisonPredicate(SemanticQueryBuilder.java:275)
	 * 	at org.hibernate.grammars.hql.HqlParser$ComparisonPredicateContext.accept(HqlParser.java:6432)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitGroupedPredicate(SemanticQueryBuilder.java:2364)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitGroupedPredicate(SemanticQueryBuilder.java:275)
	 * 	at org.hibernate.grammars.hql.HqlParser$GroupedPredicateContext.accept(HqlParser.java:6352)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSearchedCaseList(SemanticQueryBuilder.java:3301)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSearchedCaseList(SemanticQueryBuilder.java:275)
	 * 	at org.hibernate.grammars.hql.HqlParser$SearchedCaseListContext.accept(HqlParser.java:9438)
	 * 	at org.antlr.v4.runtime.tree.AbstractParseTreeVisitor.visitChildren(AbstractParseTreeVisitor.java:46)
	 * 	at org.hibernate.grammars.hql.HqlParserBaseVisitor.visitCaseList(HqlParserBaseVisitor.java:1015)
	 * 	at org.hibernate.grammars.hql.HqlParser$CaseListContext.accept(HqlParser.java:9183)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitCaseExpression(SemanticQueryBuilder.java:3255)
	 * 	at org.hibernate.grammars.hql.HqlParser$CaseExpressionContext.accept(HqlParser.java:8007)
	 * 	at org.antlr.v4.runtime.tree.AbstractParseTreeVisitor.visitChildren(AbstractParseTreeVisitor.java:46)
	 * 	at org.hibernate.grammars.hql.HqlParserBaseVisitor.visitBarePrimaryExpression(HqlParserBaseVisitor.java:777)
	 * 	at org.hibernate.grammars.hql.HqlParser$BarePrimaryExpressionContext.accept(HqlParser.java:7425)
	 * 	at org.antlr.v4.runtime.tree.AbstractParseTreeVisitor.visitChildren(AbstractParseTreeVisitor.java:46)
	 * 	at org.hibernate.grammars.hql.HqlParserBaseVisitor.visitExpressionOrPredicate(HqlParserBaseVisitor.java:917)
	 * 	at org.hibernate.grammars.hql.HqlParser$ExpressionOrPredicateContext.accept(HqlParser.java:8195)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSelectableNode(SemanticQueryBuilder.java:1430)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSelection(SemanticQueryBuilder.java:1407)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSelectClause(SemanticQueryBuilder.java:1400)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitQuery(SemanticQueryBuilder.java:1249)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitQuerySpecExpression(SemanticQueryBuilder.java:1035)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitQuerySpecExpression(SemanticQueryBuilder.java:275)
	 * 	at org.hibernate.grammars.hql.HqlParser$QuerySpecExpressionContext.accept(HqlParser.java:2132)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSimpleQueryGroup(SemanticQueryBuilder.java:1020)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSimpleQueryGroup(SemanticQueryBuilder.java:275)
	 * 	at org.hibernate.grammars.hql.HqlParser$SimpleQueryGroupContext.accept(HqlParser.java:2003)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSelectStatement(SemanticQueryBuilder.java:490)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitStatement(SemanticQueryBuilder.java:449)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.buildSemanticModel(SemanticQueryBuilder.java:322)
	 * 	at org.hibernate.query.hql.internal.StandardHqlTranslator.translate(StandardHqlTranslator.java:71)
	 * 	... 39 more
	 *
	 *
	 * Error interpreting query [Cannot invoke "org.hibernate.query.sqm.SqmExpressible.getSqmType()" because the return value of "org.hibernate.query.sqm.tree.select.SqmSelection.getExpressible()" is null] [select case when ((select case when (sum(cast(case when (str(sampleEntity2.status) = ?1) then ?2 else ?3 end as long)) = count(sampleEntity3)) then ?4 else ?5 end
	 * from SampleEntity3 sampleEntity3) <> ?6) then ?7 else ?8 end
	 * from SampleEntity2 sampleEntity2] [select case when ((select case when (sum(cast(case when (str(sampleEntity2.status) = ?1) then ?2 else ?3 end as long)) = count(sampleEntity3)) then ?4 else ?5 end
	 * from SampleEntity3 sampleEntity3) <> ?6) then ?7 else ?8 end
	 * from SampleEntity2 sampleEntity2]
	 * org.hibernate.query.sqm.InterpretationException: Error interpreting query [Cannot invoke "org.hibernate.query.sqm.SqmExpressible.getSqmType()" because the return value of "org.hibernate.query.sqm.tree.select.SqmSelection.getExpressible()" is null] [select case when ((select case when (sum(cast(case when (str(sampleEntity2.status) = ?1) then ?2 else ?3 end as long)) = count(sampleEntity3)) then ?4 else ?5 end
	 * from SampleEntity3 sampleEntity3) <> ?6) then ?7 else ?8 end
	 * from SampleEntity2 sampleEntity2] [select case when ((select case when (sum(cast(case when (str(sampleEntity2.status) = ?1) then ?2 else ?3 end as long)) = count(sampleEntity3)) then ?4 else ?5 end
	 * from SampleEntity3 sampleEntity3) <> ?6) then ?7 else ?8 end
	 * from SampleEntity2 sampleEntity2]
	 * 	at app//org.hibernate.query.hql.internal.StandardHqlTranslator.translate(StandardHqlTranslator.java:95)
	 * 	at app//org.hibernate.query.internal.QueryInterpretationCacheStandardImpl.createHqlInterpretation(QueryInterpretationCacheStandardImpl.java:145)
	 * 	at app//org.hibernate.query.internal.QueryInterpretationCacheStandardImpl.resolveHqlInterpretation(QueryInterpretationCacheStandardImpl.java:132)
	 * 	at app//org.hibernate.internal.AbstractSharedSessionContract.interpretHql(AbstractSharedSessionContract.java:802)
	 * 	at app//org.hibernate.internal.AbstractSharedSessionContract.createQuery(AbstractSharedSessionContract.java:852)
	 * 	at app//org.hibernate.internal.AbstractSharedSessionContract.createQuery(AbstractSharedSessionContract.java:765)
	 * 	at app//org.hibernate.internal.AbstractSharedSessionContract.createQuery(AbstractSharedSessionContract.java:140)
	 * 	at java.base@17.0.12/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	 * 	at java.base@17.0.12/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	 * 	at java.base@17.0.12/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	 * 	at java.base@17.0.12/java.lang.reflect.Method.invoke(Method.java:569)
	 * 	at app//org.springframework.orm.jpa.ExtendedEntityManagerCreator$ExtendedEntityManagerInvocationHandler.invoke(ExtendedEntityManagerCreator.java:364)
	 * 	at app/jdk.proxy3/jdk.proxy3.$Proxy111.createQuery(Unknown Source)
	 * 	at java.base@17.0.12/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	 * 	at java.base@17.0.12/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	 * 	at java.base@17.0.12/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	 * 	at java.base@17.0.12/java.lang.reflect.Method.invoke(Method.java:569)
	 * 	at app//org.springframework.orm.jpa.SharedEntityManagerCreator$SharedEntityManagerInvocationHandler.invoke(SharedEntityManagerCreator.java:319)
	 * 	at app/jdk.proxy3/jdk.proxy3.$Proxy111.createQuery(Unknown Source)
	 * 	at app//com.querydsl.jpa.impl.AbstractJPAQuery.createQuery(AbstractJPAQuery.java:132)
	 * 	at app//com.querydsl.jpa.impl.AbstractJPAQuery.createQuery(AbstractJPAQuery.java:125)
	 * 	at app//com.querydsl.jpa.impl.AbstractJPAQuery.fetch(AbstractJPAQuery.java:242)
	 * 	at app//spring.example.test.repository.QueryRepositoryImpl.getSampleQuery(QueryRepositoryImpl.java:41)
	 * 	at java.base@17.0.12/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	 * 	at java.base@17.0.12/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	 * 	at java.base@17.0.12/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	 * 	at java.base@17.0.12/java.lang.reflect.Method.invoke(Method.java:569)
	 * 	at app//org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:355)
	 * 	at app//org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:196)
	 * 	at app//org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
	 * 	at app//org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:768)
	 * 	at app//org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:138)
	 * 	at app//org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
	 * 	at app//org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:768)
	 * 	at app//org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:720)
	 * 	at app//spring.example.test.repository.QueryRepositoryImpl$$SpringCGLIB$$0.getSampleQuery(<generated>)
	 * 	at app//spring.example.test.TestApplicationTests.repositoryTest(TestApplicationTests.java:17)
	 * 	at java.base@17.0.12/java.lang.reflect.Method.invoke(Method.java:569)
	 * 	at java.base@17.0.12/java.util.ArrayList.forEach(ArrayList.java:1511)
	 * 	at java.base@17.0.12/java.util.ArrayList.forEach(ArrayList.java:1511)
	 * Caused by: java.lang.NullPointerException: Cannot invoke "org.hibernate.query.sqm.SqmExpressible.getSqmType()" because the return value of "org.hibernate.query.sqm.tree.select.SqmSelection.getExpressible()" is null
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSubquery(SemanticQueryBuilder.java:5144)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSubqueryExpression(SemanticQueryBuilder.java:5120)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSubqueryExpression(SemanticQueryBuilder.java:275)
	 * 	at org.hibernate.grammars.hql.HqlParser$SubqueryExpressionContext.accept(HqlParser.java:7594)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.createComparisonPredicate(SemanticQueryBuilder.java:2543)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitComparisonPredicate(SemanticQueryBuilder.java:2504)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitComparisonPredicate(SemanticQueryBuilder.java:275)
	 * 	at org.hibernate.grammars.hql.HqlParser$ComparisonPredicateContext.accept(HqlParser.java:6432)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitGroupedPredicate(SemanticQueryBuilder.java:2364)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitGroupedPredicate(SemanticQueryBuilder.java:275)
	 * 	at org.hibernate.grammars.hql.HqlParser$GroupedPredicateContext.accept(HqlParser.java:6352)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSearchedCaseList(SemanticQueryBuilder.java:3301)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSearchedCaseList(SemanticQueryBuilder.java:275)
	 * 	at org.hibernate.grammars.hql.HqlParser$SearchedCaseListContext.accept(HqlParser.java:9438)
	 * 	at org.antlr.v4.runtime.tree.AbstractParseTreeVisitor.visitChildren(AbstractParseTreeVisitor.java:46)
	 * 	at org.hibernate.grammars.hql.HqlParserBaseVisitor.visitCaseList(HqlParserBaseVisitor.java:1015)
	 * 	at org.hibernate.grammars.hql.HqlParser$CaseListContext.accept(HqlParser.java:9183)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitCaseExpression(SemanticQueryBuilder.java:3255)
	 * 	at org.hibernate.grammars.hql.HqlParser$CaseExpressionContext.accept(HqlParser.java:8007)
	 * 	at org.antlr.v4.runtime.tree.AbstractParseTreeVisitor.visitChildren(AbstractParseTreeVisitor.java:46)
	 * 	at org.hibernate.grammars.hql.HqlParserBaseVisitor.visitBarePrimaryExpression(HqlParserBaseVisitor.java:777)
	 * 	at org.hibernate.grammars.hql.HqlParser$BarePrimaryExpressionContext.accept(HqlParser.java:7425)
	 * 	at org.antlr.v4.runtime.tree.AbstractParseTreeVisitor.visitChildren(AbstractParseTreeVisitor.java:46)
	 * 	at org.hibernate.grammars.hql.HqlParserBaseVisitor.visitExpressionOrPredicate(HqlParserBaseVisitor.java:917)
	 * 	at org.hibernate.grammars.hql.HqlParser$ExpressionOrPredicateContext.accept(HqlParser.java:8195)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSelectableNode(SemanticQueryBuilder.java:1430)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSelection(SemanticQueryBuilder.java:1407)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSelectClause(SemanticQueryBuilder.java:1400)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitQuery(SemanticQueryBuilder.java:1249)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitQuerySpecExpression(SemanticQueryBuilder.java:1035)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitQuerySpecExpression(SemanticQueryBuilder.java:275)
	 * 	at org.hibernate.grammars.hql.HqlParser$QuerySpecExpressionContext.accept(HqlParser.java:2132)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSimpleQueryGroup(SemanticQueryBuilder.java:1020)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSimpleQueryGroup(SemanticQueryBuilder.java:275)
	 * 	at org.hibernate.grammars.hql.HqlParser$SimpleQueryGroupContext.accept(HqlParser.java:2003)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitSelectStatement(SemanticQueryBuilder.java:490)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.visitStatement(SemanticQueryBuilder.java:449)
	 * 	at org.hibernate.query.hql.internal.SemanticQueryBuilder.buildSemanticModel(SemanticQueryBuilder.java:322)
	 * 	at org.hibernate.query.hql.internal.StandardHqlTranslator.translate(StandardHqlTranslator.java:71)
	 * 	... 39 more
	 *
	 *
	 * OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended
	 * Disconnected from the target VM, address: 'localhost:51944', transport: 'socket'
	 * 2024-10-10T10:06:19.183+09:00  INFO 16521 --- [test] [ionShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'defaultUnit'
	 * 2024-10-10T10:06:19.184+09:00  INFO 16521 --- [test] [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
	 * 2024-10-10T10:06:19.186+09:00  INFO 16521 --- [test] [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
	 * > Task :test FAILED
	 * TestApplicationTests > repositoryTest() FAILED
	 *     org.springframework.dao.InvalidDataAccessResourceUsageException at TestApplicationTests.java:17
	 *         Caused by: org.hibernate.query.sqm.InterpretationException at TestApplicationTests.java:17
	 *             Caused by: java.lang.NullPointerException at TestApplicationTests.java:17
	 * 1 test completed, 1 failed
	 * FAILURE: Build failed with an exception.
	 * * What went wrong:
	 * Execution failed for task ':test'.
	 * > There were failing tests. See the report at: file:///Users/hh536/Downloads/test/build/reports/tests/test/index.html
	 * * Try:
	 * > Run with --scan to get full insights.
	 * BUILD FAILED in 8s
	 *
	 *
	 */

}
