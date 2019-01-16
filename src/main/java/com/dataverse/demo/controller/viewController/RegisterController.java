package com.dataverse.demo.controller.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {


    //Getmapper for the registration
    @GetMapping("/register")
    public String register(Model model) {
        return "Register";
    }

    //Post mapper for the registration
    @PostMapping(("/register"))
    public String register() {
        return "sth";
    }

}