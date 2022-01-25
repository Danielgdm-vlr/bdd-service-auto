package com.gdm.unitbv.bdd.backend.repository.bmw;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gdm.unitbv.bdd.backend.domain.entity.Car;

@Repository
public interface BMWRepository extends CrudRepository<Car, Integer> {
}
