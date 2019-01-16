package com.dataverse.demo.exception;

public class UserExistsException extends Exception {

    public UserExistsException(String errorMessage) {
        super(errorMessage);
    }
}
