package com.yeinjeong131.careeros.domain.application.dto;

import com.yeinjeong131.careeros.domain.application.Application;
import com.yeinjeong131.careeros.domain.application.ApplicationStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class ApplicationCreateRequest {

    @NotBlank(message = "Company name is required")
    private String companyName;

    private String positionTitle;

    @NotNull(message = "Status is required")
    private ApplicationStatus status;

    @NotNull(message = "Applied date is required")
    @PastOrPresent(message = "Applied date cannot be in the future.")
    private LocalDate appliedDate;

    private String jobUrl;
    private String location;
    private String notes;

    public Application toEntity() {
        return new Application(companyName, positionTitle, status, appliedDate, jobUrl, location, notes);
    }
}
