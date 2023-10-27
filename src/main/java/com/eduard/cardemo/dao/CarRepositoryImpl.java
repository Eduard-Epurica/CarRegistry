package com.eduard.cardemo.dao;

import com.eduard.cardemo.entity.Car;
import com.eduard.cardemo.entity.Owner;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepositoryImpl implements CarRepository{

    private EntityManager entityManager;


    @Autowired
    public CarRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveCar(Car theCar) {

    }

    @Override
    public Car findCarById(int theId) {
        return null;
    }

    @Override
    public Owner findOwnerById(int theId) {
        return null;
    }

    @Override
    @Transactional
    public void deleteCarById(int theId) {

    }

    @Override
    @Transactional
    public void deleteOwnerById(int theId) {

    }

    @Override
    public List<Car> findCarsByOwnerId(int theId) {
        return null;
    }

    @Override
    public List<Owner> findOwnersByLocationId(int theId) {
        return null;
    }

    @Override
    @Transactional
    public void updateCar(Car theCar) {

    }

    @Override
    @Transactional
    public void updateOwner(Owner theOwner) {

    }
}
