package com.dataverse.demo.mapper;

import com.dataverse.demo.domain.EnumUserType;
import com.dataverse.demo.dto.UserDtoCreate;
import com.dataverse.demo.forms.UserEditForm;
import com.dataverse.demo.forms.UserRegisterForm;
import org.springframework.stereotype.Component;

@Component
public class EditFormToUserMapper {

    public UserDtoCreate userDtoCreate(UserEditForm userEditForm) {

        UserDtoCreate userDtoCreate = new UserDtoCreate();

        userDtoCreate.setUserFirstName(userEditForm.getFirstName());
        userDtoCreate.setUserLastName(userEditForm.getLastName());
        userDtoCreate.setPassword(userEditForm.getPassword());
        userDtoCreate.setUserCompany(userEditForm.getCompany());
        userDtoCreate.setUserPhoneNumber(userEditForm.getPhoneNumber());
        userDtoCreate.setUserEmail(userEditForm.getEmail());
        userDtoCreate.setUserType(EnumUserType.USER);

        return userDtoCreate;
    }
}
