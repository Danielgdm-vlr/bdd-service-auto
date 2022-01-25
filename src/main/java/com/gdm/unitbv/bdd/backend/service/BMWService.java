package com.gdm.unitbv.bdd.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdm.unitbv.bdd.backend.domain.entity.Car;
import com.gdm.unitbv.bdd.backend.repository.bmw.BMWRepository;

@Service
public class BMWService {

    private final BMWRepository bmwRepository;

    @Autowired
    public BMWService(BMWRepository bmwRepository){

        this.bmwRepository = bmwRepository;
    }

    public List<Car> getAll(){

        return (List<Car>) bmwRepository.findAll();
    }

    public Car saveOrUpdate(Car car){

        return bmwRepository.save(car);
    }

    public void delete(Car car){

        bmwRepository.delete(car);
    }
}
