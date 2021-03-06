package com.dataverse.demo.mapper;


import com.dataverse.demo.domain.EnumUserType;
import com.dataverse.demo.dto.UserDtoCreate;
import com.dataverse.demo.forms.UserRegisterForm;
import org.springframework.stereotype.Component;

@Component
public class RegisterFormToUserMapper {

    public UserDtoCreate userDtoCreate(UserRegisterForm userRegisterForm) {

        UserDtoCreate userDtoCreate = new UserDtoCreate();

        userDtoCreate.setUserFirstName(userRegisterForm.getFirstName());
        userDtoCreate.setUserLastName(userRegisterForm.getLastName());
        userDtoCreate.setPassword(userRegisterForm.getPassword());
        userDtoCreate.setUserEmail(userRegisterForm.getEmail());
        userDtoCreate.setUserCompany(userRegisterForm.getCompany());
        userDtoCreate.setUserPhoneNumber(userRegisterForm.getPhoneNumber());
        userDtoCreate.setUserType(EnumUserType.USER);

        return userDtoCreate;
    }

}
