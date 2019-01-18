package com.dataverse.demo.mapper;

import com.dataverse.demo.domain.User;
import com.dataverse.demo.forms.UserRegisterForm;
import org.springframework.stereotype.Component;

@Component
public class UserToFormMapper {

    public UserRegisterForm userRegisterForm(User user) {

        UserRegisterForm userRegisterForm = new UserRegisterForm();

        userRegisterForm.setFirstName(user.getUserFirstName());
        userRegisterForm.setLastName(user.getUserLastName());
        userRegisterForm.setEmail(user.getUserEmail());
        userRegisterForm.setCompany(user.getUserCompany());
        userRegisterForm.setPhoneNumber(user.getUserPhoneNumber());
        userRegisterForm.setPassword(user.getUserPassword());

        return userRegisterForm;

    }


}
