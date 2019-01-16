package com.dataverse.demo.validators;

import com.dataverse.demo.forms.UserRegisterForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegisterValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {

        return UserRegisterForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserRegisterForm userRegisterForm = (UserRegisterForm) target;

        //here perform your checks
        if (userRegisterForm.getEmail() == null) {
            // add an error for the field called ‘email’
            errors.rejectValue("email", "email is empty");
        }
    }
}
