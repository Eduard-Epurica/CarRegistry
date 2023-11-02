package com.eduard.cardemo.controller;


import com.eduard.cardemo.dao.CarDetailRepository;
import com.eduard.cardemo.dao.MakeRepository;
import com.eduard.cardemo.entity.Car;
import com.eduard.cardemo.entity.CarDetail;
import com.eduard.cardemo.entity.Make;
import com.eduard.cardemo.entity.Owner;
import com.eduard.cardemo.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cars")
@CrossOrigin(origins = "http://localhost:8080")
public class CarController {

    private CarService carService;
    @Value("#{'${arrayOfTypes}'.split(',')}")
    List<String> types;

    @Value("#{'${arrayOfColors}'.split(',')}")
    List<String> colors;
    private final MakeRepository makeRepository;
    private final CarDetailRepository carDetailRepository;

    public CarController(CarService carService,
                         MakeRepository makeRepository,
                         CarDetailRepository carDetailRepository) {
        this.carService = carService;
        this.makeRepository = makeRepository;
        this.carDetailRepository = carDetailRepository;
    }

    @GetMapping("/list")
    public String listCars(Model theModel){

        // get the cars from the db
        List<Car> theCars = carService.findAll();

        // add to the spring model
        theModel.addAttribute("cars", theCars);

//        List<String> carDetails = new ArrayList<>();
//
//        for(Car car: theCars)
//        {
//            carDetails.add(car.getCarDetail().getType());
//        }
//
//        System.out.println(carDetails);
//
//        theModel.addAttribute("carDetails", carDetails);

        return "cars/list-cars";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        theModel.addAttribute("types", types);
        theModel.addAttribute("colors",colors);

        List<String> makeList = makeRepository.findAll().stream()
                .map(Make::getName)
                .collect(Collectors.toList());

        theModel.addAttribute("make", makeList);

        //create model attribute to find form data
        Car theCar = new Car();

        theModel.addAttribute("owner", theCar.getOwner());
        theModel.addAttribute("car", theCar);

        return "cars/cars-form";

    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("carId") int theId,Model theModel){

        Car theCar = carService.findById(theId);
        System.out.println(theCar);

        theModel.addAttribute("updateCar", theCar);

        theModel.addAttribute("types", types);
        theModel.addAttribute("colors",colors);
        List<String> makeList = makeRepository.findAll().stream()
                .map(Make::getName)
                .collect(Collectors.toList());
        theModel.addAttribute("make", makeList);


        return "cars/cars-update-form";

    }

    @PostMapping("/save")
    private String saveCar(@Valid @ModelAttribute("car") Car theCar, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "cars/cars-form";
        }else {
            //save the care
            carService.save(theCar);

            //use a redirect to prvent duplicate submissions
            return "redirect:/cars/list";
        }

    }

    @PostMapping("/update")
    private String updateCar(@ModelAttribute("car") Car theCar){

        //save the care
        carService.update(theCar);

        //use a redirect to prevent duplicate submissions
        return "redirect:/cars/list";

    }

    @GetMapping("/delete")
    private String deleteCar(@RequestParam("carId") int theId){

        //save the care
        carService.deleteById(theId);

        //use a redirect to prevent duplicate submissions
        return "redirect:/cars/list";

    }
}
