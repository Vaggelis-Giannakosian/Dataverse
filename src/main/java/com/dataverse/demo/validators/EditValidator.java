package com.dataverse.demo.validators;

import com.dataverse.demo.forms.UserEditForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EditValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {

        return UserEditForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserEditForm userEditForm = (UserEditForm) target;


    }
}
