package com.dataverse.demo.mapper;

import com.dataverse.demo.domain.User;
import com.dataverse.demo.forms.UserEditForm;
import com.dataverse.demo.forms.UserRegisterForm;
import org.springframework.stereotype.Component;

@Component
public class UserToFormMapper {

    public UserEditForm userEditForm(User user) {

        UserEditForm userEditForm = new UserEditForm();

        userEditForm.setFirstName(user.getUserFirstName());
        userEditForm.setLastName(user.getUserLastName());
        userEditForm.setCompany(user.getUserCompany());
        userEditForm.setPhoneNumber(user.getUserPhoneNumber());
        userEditForm.setPassword(user.getUserPassword());
        return userEditForm;

    }


}
