package com.dataverse.demo.service;

import com.dataverse.demo.dto.UserDtoCreate;
import com.dataverse.demo.exception.UserExistsException;

public interface UserService {


    void create(UserDtoCreate userDtoCreate) throws UserExistsException;

}
