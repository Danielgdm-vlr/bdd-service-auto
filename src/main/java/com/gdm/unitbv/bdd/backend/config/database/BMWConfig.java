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
        entityManagerFactoryRef = "beanEntityManagerFactoryRefBMWCarsDatabase",
        basePackages = "com.gdm.unitbv.bdd.backend.repository.bmw",
        transactionManagerRef = "beanTransactionManagerBMWCarsDatabase"
)
public class BMWConfig {

    @Bean(name = "beanDataSourceForBMWDatabase")
    public DataSource getDataSourceForBMWCarsDatabase(){

//        return GenericConfig.getDataSource("jdbc:postgresql://127.0.0.1:5432/--PUT YOUR DATABASE NAME HERE--" +
//                "?createDatabaseIfNotExist=true");
        return GenericConfig.getDataSource("jdbc:postgresql://127.0.0.1:5432/bdd-service-bmw" +
                "?createDatabaseIfNotExist=true");
    }

    @Bean(name = "beanEntityManagerFactoryRefBMWCarsDatabase")
    public LocalContainerEntityManagerFactoryBean
    localContainerEntityManagerFactoryBeanForBeanEntityManagerFactoryRefBMWCarsDatabase(
            EntityManagerFactoryBuilder entityManagerFactoryBuilderBMWCarsDatabase,
            @Qualifier("beanDataSourceForBMWDatabase") DataSource dataSourceBMWCars){

        return entityManagerFactoryBuilderBMWCarsDatabase.dataSource(dataSourceBMWCars)
                .properties(GenericConfig.getProperties())
                .packages("com.gdm.unitbv.bdd.backend.domain.entity")
//                .persistenceUnit("--PUT YOUR DATABASE NAME HERE--")
                .persistenceUnit("bdd-service-bmw")
                .build();
    }

    @Bean(name = "beanTransactionManagerBMWCarsDatabase")
    public PlatformTransactionManager platformTransactionManagerBMWCarsDatabase(
            @Qualifier("beanEntityManagerFactoryRefBMWCarsDatabase") EntityManagerFactory
                    entityManagerFactoryBMWCarsDatabase){

        return new JpaTransactionManager(entityManagerFactoryBMWCarsDatabase);
    }
}