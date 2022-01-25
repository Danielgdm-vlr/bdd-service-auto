package com.gdm.unitbv.bdd.backend.repository.mercedes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gdm.unitbv.bdd.backend.domain.entity.Car;

@Repository
public interface MercedesRepository extends CrudRepository<Car, Integer> {
}
