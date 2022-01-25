package com.gdm.unitbv.bdd.backend.config.database;

import com.gdm.unitbv.bdd.backend.config.util.GenericConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        entityManagerFactoryRef = "beanEntityManagerFactoryRefMercedesCarsDatabase",
        basePackages = "com.gdm.unitbv.bdd.backend.repository.mercedes",
        transactionManagerRef = "beanTransactionManagerBDDFantasyBooks"
)
public class MercedesConfig {

    @Primary
    @Bean(name = "beanDataSourceForMercedesCarsDatabase")
    public DataSource getDataSourceForMercedesCarsDatabase(){

//        return GenericConfig.getDataSource("jdbc:postgresql://127.0.0.1:5432/--PUT YOUR DATABASE NAME HERE--" +
//                "?createDatabaseIfNotExist=true");
        return GenericConfig.getDataSource("jdbc:postgresql://127.0.0.1:5432/bdd-service-mercedes" +
                "?createDatabaseIfNotExist=true");
    }

    @Primary
    @Bean(name = "beanEntityManagerFactoryRefMercedesCarsDatabase")
    public LocalContainerEntityManagerFactoryBean
    localContainerEntityManagerFactoryBeanForBeanEntityManagerFactoryRefMercedesCarsDatabase(
            EntityManagerFactoryBuilder entityManagerFactoryBuilderMercedesCarsDatabase,
            @Qualifier("beanDataSourceForMercedesCarsDatabase") DataSource dataSourceMercedesCars){

        return entityManagerFactoryBuilderMercedesCarsDatabase.dataSource(dataSourceMercedesCars)
                .properties(GenericConfig.getProperties())
                .packages("com.gdm.unitbv.bdd.backend.domain.entity")
//                .persistenceUnit("--PUT YOUR DATABASE NAME HERE--")
                .persistenceUnit("bdd-service-mercedes")
                .build();
    }

    @Primary
    @Bean(name = "beanTransactionManagerBDDFantasyBooks")
    public PlatformTransactionManager platformTransactionManagerFantasy(
            @Qualifier("beanEntityManagerFactoryRefMercedesCarsDatabase") EntityManagerFactory
                    entityManagerFactoryMercedesCarsDatabase){

        return new JpaTransactionManager(entityManagerFactoryMercedesCarsDatabase);
    }
}