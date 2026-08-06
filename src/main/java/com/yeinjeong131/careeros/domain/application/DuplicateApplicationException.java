package com.yeinjeong131.careeros.domain.application;

public class DuplicateApplicationException extends RuntimeException {

    public DuplicateApplicationException(String companyName, String positionTitle) {
        super("You have already applied to " + companyName + " for " + positionTitle + ".");
    }
}
