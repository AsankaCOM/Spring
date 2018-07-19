package com.ecaphi.cars.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecaphi.cars.model.Car;

@Repository
public interface ReservationResository extends CrudRepository<Car, Integer> {
}
