package com.eduard.cardemo.service;

import com.eduard.cardemo.dao.CarRepository;
import com.eduard.cardemo.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAllCars();
    }

    @Override
    public Car findById(int theId) {
        return null;
    }

    @Override
    public void save(Car theCar) {
        carRepository.saveCar(theCar);
    }

    @Override
    public void deleteById(int theId) {

    }
}
