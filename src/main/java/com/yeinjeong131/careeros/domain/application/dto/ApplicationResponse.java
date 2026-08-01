package com.yeinjeong131.careeros.domain.application.dto;

import com.yeinjeong131.careeros.domain.application.Application;
import com.yeinjeong131.careeros.domain.application.ApplicationStatus;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class ApplicationResponse {
    private final Long id;
    private final String companyName;
    private final String positionTitle;
    private final ApplicationStatus status;
    private final LocalDate appliedDate;
    private final String jobUrl;
    private final String location;
    private final String notes;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public ApplicationResponse(Application application) {
        this.id = application.getId();
        this.companyName = application.getCompanyName();
        this.positionTitle = application.getPositionTitle();
        this.status = application.getStatus();
        this.appliedDate = application.getAppliedDate();
        this.jobUrl = application.getJobUrl();
        this.location = application.getLocation();
        this.notes = application.getNotes();
        this.createdAt = application.getCreatedAt();
        this.updatedAt = application.getUpdatedAt();
    }
}
