package spring.example.test.config;

import com.querydsl.jpa.JPQLTemplates;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean(EntityManagerFactory.class)
@ConditionalOnClass({JPAQueryFactory.class})
public class QueryDslConfig {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    @ConditionalOnMissingBean(name = "jpaQueryFactory", value = JPAQueryFactory.class)
    public JPAQueryFactory jpaQueryFactory() {

        return new JPAQueryFactory(JPQLTemplates.DEFAULT, entityManager);
    }
}
