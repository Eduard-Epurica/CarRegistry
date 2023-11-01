package com.eduard.cardemo.dao;

import com.eduard.cardemo.entity.Car;
import com.eduard.cardemo.entity.Owner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
    public List<Car> findAllCars() {
        //create a custom query for retrieving the cars
        TypedQuery<Car> query = entityManager.createQuery(
                "FROM Car WHERE id>0", Car.class);

        //execute query
        List<Car> cars = query.getResultList();

        return cars;
    }

    @Override
    @Transactional
    public void saveCar(Car theCar) {

        entityManager.persist(theCar);

    }

    @Override
    public Car findCarById(int theId) {
        return entityManager.find(Car.class,theId);
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

        Car tempCar = entityManager.find(Car.class,theCar.getId());

        tempCar.setModel(theCar.getModel());
        tempCar.setCarDetail(theCar.getCarDetail());
        tempCar.setMake(theCar.getMake());
        tempCar.setOwner(theCar.getOwner());
        tempCar.setVin(theCar.getVin());
        tempCar.setLocation(theCar.getLocation());

        entityManager.merge(tempCar);
    }

    @Override
    @Transactional
    public void updateOwner(Owner theOwner) {

    }
}
