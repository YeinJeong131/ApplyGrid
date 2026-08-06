package com.yeinjeong131.careeros.domain.application;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
@Getter
// didn't make setter I will make update() and changStatus() to change the data
@NoArgsConstructor
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name", length = 100, nullable = false)
    private String companyName;

    @Column(name = "position_title", length = 100)
    private String positionTitle;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    private ApplicationStatus status;

    @Column(name = "applied_date", nullable = false)
    private LocalDate appliedDate;

    @Column(name = "job_url", length = 500)
    private String jobUrl;

    @Column(name = "location", length = 100)
    private String location;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Application(String companyName, String positionTitle, ApplicationStatus status, LocalDate appliedDate, String jobUrl, String location, String notes) {
        this.companyName = companyName;
        this.positionTitle = positionTitle;
        this.status = status;
        this.appliedDate = appliedDate;
        this.jobUrl = jobUrl;
        this.location = location;
        this.notes = notes;
    }

    public void update(String companyName, String positionTitle, ApplicationStatus status, LocalDate appliedDate, String jobUrl, String location, String notes) {
        this.companyName = companyName;
        this.positionTitle = positionTitle;
        this.status = status;
        this.appliedDate = appliedDate;
        this.jobUrl = jobUrl;
        this.location = location;
        this.notes = notes;
    }

}