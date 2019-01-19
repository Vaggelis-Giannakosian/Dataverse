package com.dataverse.demo.security;

import com.dataverse.demo.domain.EnumUserType;
import com.dataverse.demo.dto.UserDtoLogin;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import java.util.Collections;


@Service
public class AuthenticationService {
    public UserDtoLogin login(String email, String password){
        return new UserDtoLogin(email, password, Collections.singletonList(new SimpleGrantedAuthority(EnumUserType.USER.toString())));
    }
}
