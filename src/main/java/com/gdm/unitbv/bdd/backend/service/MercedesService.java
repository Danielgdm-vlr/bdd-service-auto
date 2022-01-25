package com.gdm.unitbv.bdd.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdm.unitbv.bdd.backend.domain.entity.Car;
import com.gdm.unitbv.bdd.backend.repository.mercedes.MercedesRepository;

@Service
public class MercedesService {

    private final MercedesRepository mercedesRepository;

    @Autowired
    public MercedesService(MercedesRepository mercedesRepository){

        this.mercedesRepository = mercedesRepository;
    }

    public List<Car> getAll(){

        return (List<Car>) mercedesRepository.findAll();
    }

    public Car saveOrUpdate(Car car){

        return mercedesRepository.save(car);
    }

    public void delete(Car car){

        mercedesRepository.delete(car);
    }
}
