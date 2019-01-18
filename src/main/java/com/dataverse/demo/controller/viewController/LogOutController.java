package com.dataverse.demo.controller.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogOutController {

    @GetMapping("/logOut")
    public String logOutView(){
        return "";
    }

}
