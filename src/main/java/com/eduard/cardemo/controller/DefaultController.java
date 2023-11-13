package com.eduard.cardemo.controller;

import com.eduard.cardemo.security.WebUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String defaultMapping(Model theModel) {

        return "redirect:/cars/list";
    }

    @GetMapping("/showLoginPage")
    public String showLoginPage() {

        return "login/cars-login";
    }


    // add a request mapping for /access-denied
//
//    @RequestMapping("/access-denied")
//    public String showAccessDenied() {
//        return "access-denied";
//
//    }
}
