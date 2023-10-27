package com.eduard.cardemo.service;

import com.eduard.cardemo.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> findAll();

    Car findById(int theId);

    void save(Car theCar);

    void deleteById(int theId);


}
