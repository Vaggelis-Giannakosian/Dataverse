package com.dataverse.demo.controller.restController;

import com.dataverse.demo.dto.UserDtoCreate;
import com.dataverse.demo.exception.UserExistsException;
import com.dataverse.demo.service.UserService;
import com.dataverse.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

@Autowired
    private UserServiceImpl userService;

    @PostMapping(path="/api/Person/create")
    public int AddCustomPerson(@RequestBody UserDtoCreate userDtoCreate) throws UserExistsException {
        if(userDtoCreate!=null) {
            userService.create(userDtoCreate);
            return 200;
        }else {
            return 300;
        }
    }
}
