package com.gdm.unitbv.bdd.backend.config.util;

import com.gdm.unitbv.bdd.backend.domain.entity.Car;
import com.gdm.unitbv.bdd.backend.domain.util.Maker;
import com.gdm.unitbv.bdd.backend.service.AudiService;
import com.gdm.unitbv.bdd.backend.service.BMWService;
import com.gdm.unitbv.bdd.backend.service.MercedesService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitialInsert {

    @Bean
    public CommandLineRunner commandLineRunnerInsertMercedesCarsInMercedesDatabase(
            MercedesService mercedesService){

        return args -> {
            for(int counter = 0; counter < 3; counter++){
                mercedesService.saveOrUpdate(new Car(
                   Maker.MercedesBenz,
                   "E 220d",
                   72500.0
                ));
            }
        };
    }

    @Bean
    public CommandLineRunner commandLineRunnerInsertBMWCarsInBMWCarsDatabase(
            BMWService bmwService){

        return args -> {
            for(int counter = 0; counter < 3; counter++){
                bmwService.saveOrUpdate(new Car(
                        Maker.BMW,
                        "320i",
                        57500.0
                ));
            }
        };
    }

    @Bean
    public CommandLineRunner commandLineRunnerInsertAudiCarsInAudiDatabase(
            AudiService audiService){

        return args -> {
            for(int counter = 0; counter < 3; counter++){
                audiService.saveOrUpdate(new Car(
                        Maker.Audi,
                        "A3 2.0",
                        30000.0
                ));
            }
        };
    }
}
