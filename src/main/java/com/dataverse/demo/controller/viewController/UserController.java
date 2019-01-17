package com.dataverse.demo.controller.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/home")
    public String home( ) {

        return "Home";
    }

    @GetMapping("/home/edit")
    public String edit( ) {

        return "UserEdit";
    }

}
