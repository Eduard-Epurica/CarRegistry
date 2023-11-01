package com.eduard.cardemo.service;

import com.eduard.cardemo.dao.*;
import com.eduard.cardemo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;
    private OwnerRepository ownerRepository;
    private MakeRepository makeRepository;
    private  CarDetailRepository carDetailRepository;

    private LocationRepository locationRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, OwnerRepository ownerRepository, MakeRepository makeRepository, CarDetailRepository carDetailRepository, LocationRepository locationRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
        this.makeRepository = makeRepository;
        this.carDetailRepository = carDetailRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAllCars();
    }

    @Override
    public Car findById(int theId) {
        return carRepository.findCarById(theId);
    }

    @Override
    public void save(Car theCar) {

        Owner theOwner = ownerRepository.findByFirstNameAndLastName(theCar.getOwner().getFirstName(), theCar.getOwner().getLastName());
        Make theMake = makeRepository.findByName(theCar.getMake().getName());

        //Build assocation with existing db data

        theCar.setMake(theMake);
        if(theOwner != null){
            theCar.setOwner(theOwner);
        }

        carRepository.saveCar(theCar);
    }

    @Override
    public void deleteById(int theId) {
        carRepository.deleteCarById(theId);
    }

    @Override
    public void update(Car theCar) {

        Car oldCar = carRepository.findCarById(theCar.getId());

        Owner theOwner = ownerRepository.findByFirstNameAndLastName(theCar.getOwner().getFirstName(), theCar.getOwner().getLastName());
        Make theMake = makeRepository.findByName(theCar.getMake().getName());
        Location location = locationRepository.findByPostCode(theCar.getLocation().getPostCode());


        System.out.println(theCar.getCarDetail().getId());

        //Build association with existing db data
        theCar.getCarDetail().setId(oldCar.getCarDetail().getId());
        theCar.setMake(theMake);

        if(theOwner != null){
            theCar.setOwner(theOwner);
        }
        if(location != null){
            theCar.setLocation(location);
        }

        carRepository.updateCar(theCar);
    }
}
