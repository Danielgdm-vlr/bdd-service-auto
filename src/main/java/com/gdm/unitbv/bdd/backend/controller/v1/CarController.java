package com.gdm.unitbv.bdd.backend.controller.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gdm.unitbv.bdd.backend.domain.entity.Car;
import com.gdm.unitbv.bdd.backend.service.CarService;

@RestController
@RequestMapping("api/v1/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService){

        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAll(){

        return carService.getAll();
    }

    @PostMapping
    public Car saveOrUpdate(@RequestBody Car car){

        return carService.saveOrUpdate(car);
    }

    @PutMapping
    public Car update(@RequestBody Car car){

        return carService.saveOrUpdate(car);
    }

    @DeleteMapping
    public void delete(@RequestBody Car car){

        carService.delete(car);
    }
}
