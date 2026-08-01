package com.yeinjeong131.careeros.domain.application.dto;

import com.yeinjeong131.careeros.domain.application.ApplicationStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class ApplicationUpdateRequest {

    private String companyName;
    private String positionTitle;
    private ApplicationStatus status;
    private LocalDate appliedDate;
    private String jobUrl;
    private String location;
    private String notes;
}
