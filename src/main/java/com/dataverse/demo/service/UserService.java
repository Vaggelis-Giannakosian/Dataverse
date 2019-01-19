package com.dataverse.demo.service;

import com.dataverse.demo.domain.User;
import com.dataverse.demo.dto.UserDtoCreate;
import com.dataverse.demo.exception.UserExistsException;

public interface UserService {


    void create(UserDtoCreate userDtoCreate) throws UserExistsException;

    User getUserProfile(String email);
    void updateUser(UserDtoCreate userDtoCreate,Long id);
    User getUserForLogIn(String email, String password);

}
