package com.eduard.cardemo.dao;

import com.eduard.cardemo.entity.Car;
import com.eduard.cardemo.entity.Owner;

import java.util.List;

public interface CarRepository {


    void saveCar(Car theCar);

    Car findCarById(int theId);

    Owner findOwnerById(int theId);

    void deleteCarById(int theId);

    void deleteOwnerById(int theId);

    List<Car> findCarsByOwnerId(int theId);

    List<Owner> findOwnersByLocationId(int theId);

    void updateCar(Car theCar);

    void updateOwner(Owner theOwner);


}
