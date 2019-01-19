package com.dataverse.demo.security;

import com.dataverse.demo.dto.SetUserDto;
import com.dataverse.demo.dto.UserDtoLogin;
import com.dataverse.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class AccountLoginAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserServiceImpl userService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDtoLogin loginResponse = authenticateUser(authentication);
        return new UsernamePasswordAuthenticationToken(loginResponse.getEmail(), loginResponse.getPassword(), loginResponse.getPersonType());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private UserDtoLogin authenticateUser(Authentication authentication) {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        var user = userService.getUserForLogIn(username, password);

        if(user==null){
            throw new BadCredentialsException("User or password incorrect");
        }else {
            SetUserDto setUserDto = new SetUserDto();
            return setUserDto.setUserForLogIn(user);
        }

    }


}
