package com.gdm.unitbv.bdd.backend.repository.audi;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gdm.unitbv.bdd.backend.domain.entity.Car;

@Repository
public interface AudiRepository extends CrudRepository<Car, Integer> {
}
