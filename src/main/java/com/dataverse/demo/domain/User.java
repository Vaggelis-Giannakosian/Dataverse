package com.dataverse.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

    private static final int MAX_NAME_LENGTH  = 60;
    private static final int MAX_PHONE_LENGTH = 10;

    @Id
    @Column(name = "person_id", nullable = false)
    @GeneratedValue(generator="increment",strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_first_name", length = MAX_NAME_LENGTH)
    private String userFirstName;

    @Column(name = "user_last_name", length = MAX_NAME_LENGTH)
    private String userLastName;

    @Column(name = "user_email",length = MAX_NAME_LENGTH, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userEmail;

    @Column(name = "user_phone_number",length = MAX_PHONE_LENGTH)
    private Long userPhoneNumber;

    @Column(name = "user_company",length = MAX_PHONE_LENGTH)
    private String userCompany;

    @Column(name = "user_pass",length = MAX_NAME_LENGTH)
    private String userPassword;

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(Long userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(String userCompany) {
        this.userCompany = userCompany;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}

