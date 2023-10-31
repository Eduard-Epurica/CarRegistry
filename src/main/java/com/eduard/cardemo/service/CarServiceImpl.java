package com.eduard.cardemo.service;

import com.eduard.cardemo.dao.CarRepository;
import com.eduard.cardemo.dao.MakeRepository;
import com.eduard.cardemo.dao.OwnerRepository;
import com.eduard.cardemo.entity.Car;
import com.eduard.cardemo.entity.Make;
import com.eduard.cardemo.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;
    private OwnerRepository ownerRepository;

    private MakeRepository makeRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, OwnerRepository ownerRepository, MakeRepository makeRepository) {
        this.ownerRepository = ownerRepository;
        this.carRepository = carRepository;
        this.makeRepository = makeRepository;
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

    }
}
