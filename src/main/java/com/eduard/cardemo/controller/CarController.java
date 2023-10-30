package com.eduard.cardemo.controller;


import com.eduard.cardemo.entity.Car;
import com.eduard.cardemo.entity.CarDetail;
import com.eduard.cardemo.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/list")
    public String listCars(Model theModel){

        // get the cars from the db
        List<Car> theCars = carService.findAll();

        // add to the spring model
        theModel.addAttribute("cars", theCars);

        List<String> carDetails = new ArrayList<>();

        for(Car car: theCars)
        {
            carDetails.add(car.getCarDetail().getType());
        }

        theModel.addAttribute("carDetails", carDetails);

        return "cars/list-cars";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        //create model attribute to find form data
        Car theCar = new Car();

        theModel.addAttribute("car", theCar);

        return "cars/cars-form";

    }

    @PostMapping("/save")
    private String saveCar(@ModelAttribute("car") Car theCar){

        //save the care
        carService.save(theCar);

        //use a redirect to prvent duplicate submissions
        return "redirect:/cars/list";

    }
}
