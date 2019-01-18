package com.dataverse.demo.controller.viewController;

import com.dataverse.demo.domain.User;
import com.dataverse.demo.dto.UserDtoCreate;
import com.dataverse.demo.forms.UserRegisterForm;
import com.dataverse.demo.mapper.RegisterFormToUserMapper;
import com.dataverse.demo.mapper.UserToFormMapper;
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
public class UserController {
    public static final String ERROR_MESSAGE = "errorMessage";
    private static final String REGISTER_FORM = "userRegisterForm";

    private RegisterValidator registerValidator;

    @Autowired
    private RegisterFormToUserMapper mapper;

    @Autowired
    private UserToFormMapper userMapper;

    @Autowired
    UserServiceImpl userService;

    @InitBinder(REGISTER_FORM)
    protected void initBinder(final WebDataBinder binder) {
        binder.addValidators(registerValidator);
    }



    @GetMapping("/home")
    public String home(Model model ) {

//      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserProfile("e.giannakosian@gmail.com");
        model.addAttribute("user",user);

        return "Home";
    }

    @GetMapping("/home/edit")
    public String edit(Model model ) {
        if (!model.asMap().containsKey(REGISTER_FORM)) {
            User user = userService.getUserProfile("e.giannakosian@gmail.com");
            UserRegisterForm userRegisterForm = userMapper.userRegisterForm(user);
            model.addAttribute(REGISTER_FORM, userRegisterForm);
        }
        return "UserEdit";

    }

    @PostMapping("/home/edit")
    public String editUpdate(Model model,
                             @Valid @ModelAttribute(REGISTER_FORM)
                                     UserRegisterForm userRegisterForm,
                             BindingResult bindingResult ){

    if (bindingResult.hasErrors()) {
        model.addAttribute(ERROR_MESSAGE, "an error occurred");
        return "UserEdit";
    }try {
            User user = userService.getUserProfile("e.giannakosian@gmail.com");
            UserDtoCreate userDtoCreate = mapper.userDtoCreate(userRegisterForm);
            userService.updateUser(userDtoCreate, user.getUserId());
            return "redirect:/home";
        } catch (Exception ex) {
            model.addAttribute(REGISTER_FORM, userRegisterForm);
            model.addAttribute("error", "Couldn't update profile. The Email already exists.");
            return "UserEdit";
        }

    }





}



