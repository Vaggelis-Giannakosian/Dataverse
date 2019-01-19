package com.dataverse.demo.dto;

import com.dataverse.demo.domain.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

public class SetUserDto {

    public UserDto setUserDto(User user){
        UserDto userDto = new UserDto();

        userDto.setId(user.getUserId());
        userDto.setFirstName(user.getUserFirstName());
        userDto.setLastName(user.getUserLastName());
        userDto.setEmail(user.getUserEmail());
        userDto.setCompany(user.getUserCompany());
        userDto.setPassword(user.getUserPassword());
        userDto.setPhoneNumber(user.getUserPhoneNumber());
        return userDto;
    }

    public UserDtoLogin setUserForLogIn(User user){
        UserDtoLogin userDtoLogin =new UserDtoLogin(user.getUserEmail(),user.getUserPassword(),Collections.singletonList(new SimpleGrantedAuthority(user.getUserType().toString())));
        return userDtoLogin;
    }
}
