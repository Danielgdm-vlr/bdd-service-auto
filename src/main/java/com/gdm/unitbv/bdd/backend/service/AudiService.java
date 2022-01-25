package com.gdm.unitbv.bdd.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdm.unitbv.bdd.backend.domain.entity.Car;
import com.gdm.unitbv.bdd.backend.repository.audi.AudiRepository;

@Service
public class AudiService {

    private final AudiRepository audiRepository;

    @Autowired
    public AudiService(AudiRepository audiRepository){

        this.audiRepository = audiRepository;
    }

    public List<Car> getAll(){

        return (List<Car>) audiRepository.findAll();
    }

    public Car saveOrUpdate(Car car){

        return audiRepository.save(car);
    }

    public void delete(Car car){

        audiRepository.delete(car);
    }
}
