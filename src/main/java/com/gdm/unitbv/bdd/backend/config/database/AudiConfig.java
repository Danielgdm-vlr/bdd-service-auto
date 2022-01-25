package com.gdm.unitbv.bdd.backend.config.database;

import com.gdm.unitbv.bdd.backend.config.util.GenericConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "beanEntityManagerFactoryRefAudiCarsDatabase",
        basePackages = "com.gdm.unitbv.bdd.backend.repository.audi",
        transactionManagerRef = "beanTransactionManagerAudiCarsDatabase"
)
public class AudiConfig {

    @Bean(name = "beanDataSourceForAudiDatabase")
    public DataSource getDataSourceForAudiCarsDatabase(){

//        return GenericConfig.getDataSource("jdbc:postgresql://127.0.0.1:5432/--PUT YOUR DATABASE NAME HERE--" +
//                "?createDatabaseIfNotExist=true");
        return GenericConfig.getDataSource("jdbc:postgresql://127.0.0.1:5432/bdd-service-audi" +
                "?createDatabaseIfNotExist=true");
    }

    @Bean(name = "beanEntityManagerFactoryRefAudiCarsDatabase")
    public LocalContainerEntityManagerFactoryBean
    localContainerEntityManagerFactoryBeanForBeanEntityManagerFactoryRefAudiCarsDatabase(
            EntityManagerFactoryBuilder entityManagerFactoryBuilderAudiCarsDatabase,
            @Qualifier("beanDataSourceForAudiDatabase") DataSource dataSourceAudiCars){

        return entityManagerFactoryBuilderAudiCarsDatabase.dataSource(dataSourceAudiCars)
                .properties(GenericConfig.getProperties())
                .packages("com.gdm.unitbv.bdd.backend.domain.entity")
//                .persistenceUnit("--PUT YOUR DATABASE NAME HERE--")
                .persistenceUnit("bdd-service-audi")
                .build();
    }

    @Bean(name = "beanTransactionManagerAudiCarsDatabase")
    public PlatformTransactionManager platformTransactionManagerAudiCarsDatabase(
            @Qualifier("beanEntityManagerFactoryRefAudiCarsDatabase") EntityManagerFactory
                    entityManagerFactoryAudiCarsDatabase){

        return new JpaTransactionManager(entityManagerFactoryAudiCarsDatabase);
    }
}