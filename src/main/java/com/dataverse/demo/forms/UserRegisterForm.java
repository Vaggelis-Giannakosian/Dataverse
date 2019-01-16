package com.dataverse.demo.forms;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegisterForm {



    private static final String NAME_PATTERN = "^[a-zA-Z]*$";
    private static final String PHONE_NUMBER_PATTERN = "^[0-9]*$";
    private static final String MAIL_PATTERN = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$";
    private static final int PASSWORD_MINSIZE = 8;
    private static final int PHONE_NUMBER_SIZE=10;
    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9@#$%^&]*$";


    private Long id;


    @Pattern(regexp = NAME_PATTERN, message = "The First Name cannot be empty and must contains only letters.")
    private String firstName;

    @Pattern(regexp = NAME_PATTERN, message = "The Last Name cannot be empty and must contains only letters.")
    private String lastName;

    //TODO change the password regexp
    @Pattern(regexp = PASSWORD_PATTERN, message="Password should.....")
    @Size(min = PASSWORD_MINSIZE , message = "Password must contain more than 8 characters.")
    private String password;


    @Pattern(regexp = MAIL_PATTERN, message = "Invalid mail format.")
    private String email;

    @Pattern(regexp = PHONE_NUMBER_PATTERN , message="The telephone number should contain only digits.")
    @Size(min = PHONE_NUMBER_SIZE,max = PHONE_NUMBER_SIZE, message = "The phone number should contain 10 digits.")
    private String phoneNumber;

    private String company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
