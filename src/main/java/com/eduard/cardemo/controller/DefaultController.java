package com.eduard.cardemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String defaultMapping(Model theModel) {
        return "redirect:/cars/list";
    }
}
