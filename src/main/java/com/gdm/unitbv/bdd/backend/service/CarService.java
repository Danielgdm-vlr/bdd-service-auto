package com.gdm.unitbv.bdd.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdm.unitbv.bdd.backend.domain.entity.Car;

@Service
public class CarService {

    private final MercedesService mercedesService;
    private final AudiService audiService;
    private final BMWService bmwService;

    @Autowired
    public CarService(MercedesService mercedesService,
                         AudiService audiService,
                         BMWService bmwService){

        this.mercedesService = mercedesService;
        this.audiService = audiService;
        this.bmwService = bmwService;
    }

    public List<Car> getAll(){

        List<Car> allCarsFromAllDatabases = new ArrayList<>();
        allCarsFromAllDatabases.addAll(mercedesService.getAll());
        allCarsFromAllDatabases.addAll(audiService.getAll());
        allCarsFromAllDatabases.addAll(bmwService.getAll());

        return allCarsFromAllDatabases;
    }

    public Car saveOrUpdate(Car car){

        switch (car.getMaker()){
            case MercedesBenz:
                return mercedesService.saveOrUpdate(car);
            case Audi:
                return audiService.saveOrUpdate(car);
            case BMW:
                return bmwService.saveOrUpdate(car);
            default:
                System.out.printf("Car maker unknown: %s. Cannot Update\n", car.getMaker());
                return null;
        }
    }

    public void delete(Car car){

        switch (car.getMaker()){
            case MercedesBenz:
                mercedesService.delete(car);
            case Audi:
                audiService.delete(car);
            case BMW:
                bmwService.delete(car);
            default:
                System.out.printf("Car maker unknown: %s. Cannot delete!\n", car.getMaker());
        }
    }
}
