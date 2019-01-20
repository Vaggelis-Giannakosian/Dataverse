package com.dataverse.demo.controller.viewController;

import com.dataverse.demo.domain.EnumUserType;
import com.dataverse.demo.dto.UserDtoCreate;
import com.dataverse.demo.forms.UserRegisterForm;
import com.dataverse.demo.mapper.RegisterFormToUserMapper;
import com.dataverse.demo.service.UserServiceImpl;
import com.dataverse.demo.validators.ReCaptchaResponse;
import com.dataverse.demo.validators.RegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/register" , method=RequestMethod.POST)
    public String register(@RequestParam(name="g-recaptcha-response") String captchaResponse, Model model,
                           @Valid @ModelAttribute(REGISTER_FORM)
                                   UserRegisterForm userRegisterForm,
                           BindingResult bindingResult) {
        String url="https://www.google.com/recaptcha/api/siteverify";
        String params = "?secret=6LeTLYsUAAAAAOxhax-wcTg1qiJSJd7wRKqmcXEq&response="+captchaResponse;
        ReCaptchaResponse reCaptchaResponse = restTemplate.exchange(url+params, HttpMethod.POST,null, ReCaptchaResponse.class).getBody();
        if (reCaptchaResponse.isSuccess()){

            if (bindingResult.hasErrors()) {
                return "Register";
            }
            try{
                UserDtoCreate userDtoCreate = mapper.userDtoCreate(userRegisterForm);
                userDtoCreate.setUserType(EnumUserType.USER);
                userService.create(userDtoCreate);
                return "redirect:/";
            }catch (Exception ex) {
                model.addAttribute(REGISTER_FORM, userRegisterForm);
                model.addAttribute("errorMessage", "Registration could not be complete. Email already exists in Database.");
                return "Register";
            }

        }else{
            model.addAttribute("recaptcha","You must verify captcha before registration");
            return "Register";
        }



    }

}