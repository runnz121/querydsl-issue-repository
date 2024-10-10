package spring.example.test.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.SpringBeanContainer;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class JpaConfig {

    public static final String SCAN_PATH = "spring.example.test";


    @Configuration
    @EnableJpaRepositories(
            basePackages = JpaConfig.SCAN_PATH
    )
    public static class DefaultJpaConfiguration {
        @Primary
        @Bean
        public LocalContainerEntityManagerFactoryBean entityManagerFactory(
                EntityManagerFactoryBuilder builder,
                ConfigurableListableBeanFactory beanFactory,
                @Qualifier("dataSource") DataSource dataSource
        ) {

            Map<String, String> properties = new HashMap<>();
            LocalContainerEntityManagerFactoryBean emfb = builder
                    .dataSource(dataSource)
                    .properties(properties)
                    .packages(SCAN_PATH)
                    .persistenceUnit("defaultUnit")
                    .build();

            emfb.getJpaPropertyMap().put(AvailableSettings.BEAN_CONTAINER, new SpringBeanContainer(beanFactory));
            return emfb;
        }

        @Primary
        @Bean
        public PlatformTransactionManager transactionManager(
                @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory
        ) {

            final JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(entityManagerFactory);
            return transactionManager;
        }
    }
}
