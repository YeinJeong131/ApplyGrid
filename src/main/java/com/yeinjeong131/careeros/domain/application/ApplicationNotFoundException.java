package com.yeinjeong131.careeros.domain.application;

public class ApplicationNotFoundException extends RuntimeException {
    public ApplicationNotFoundException(Long id) {
        super("Application with id " + id + " not found");
    }
}
