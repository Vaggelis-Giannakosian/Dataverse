package com.dataverse.demo.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class UserDtoLogin {
    private String email;
    private String password;
    private List<GrantedAuthority> personType;

    public UserDtoLogin(String email, String password, List<GrantedAuthority> authorities) {

        this.email = email;
        this.password = password;
        this.personType = authorities;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<GrantedAuthority> getPersonType() {
        return personType;
    }

    public void setPersonType(List<GrantedAuthority> personType) {
        this.personType = personType;
    }
}
