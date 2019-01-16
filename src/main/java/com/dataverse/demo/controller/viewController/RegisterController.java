package com.dataverse.demo.controller.viewController;

import com.dataverse.demo.dto.UserDtoCreate;
import com.dataverse.demo.forms.UserRegisterForm;
import com.dataverse.demo.mapper.RegisterFormToUserMapper;
import com.dataverse.demo.service.UserServiceImpl;
import com.dataverse.demo.validators.RegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    public static final String ERROR_MESSAGE = "errorMessage";
    private static final String REGISTER_FORM = "userRegisterForm";

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RegisterValidator registerValidator;

    @Autowired
    private RegisterFormToUserMapper mapper;

    @InitBinder(REGISTER_FORM)
    protected void initBinder(final WebDataBinder binder) {
        binder.addValidators(registerValidator);
    }

    //Getmapper for the registration

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute(REGISTER_FORM,
                new UserRegisterForm());
        return "Register";
    }


    @PostMapping(value = "/register")
    public String register(Model model,
                           @Valid @ModelAttribute(REGISTER_FORM)
                                   UserRegisterForm userRegisterForm,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            //have some error handling here, perhaps add extra error messages to the model
//            model.addAttribute(ERROR_MESSAGE, "an error occurred");
            return "Register";
        }
        try{
            UserDtoCreate personDtoCreate = mapper.userDtoCreate(userRegisterForm);
            userService.create(personDtoCreate);
            return "redirect:/";
        }catch (Exception ex) {
            model.addAttribute(REGISTER_FORM, userRegisterForm);
            model.addAttribute("errorMessage", "Registration could not be complete. Email cannot be duplicate.");
            return "Register";
        }
    }

}