package com.yeinjeong131.careeros.domain.application;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByCompanyNameContainingIgnoreCaseOrPositionTitleContainingIgnoreCaseOrNotesContainingIgnoreCase(String companyKeyword, String positionKeyword, String noteKeyword, Sort sort);

    List<Application> findByStatus(ApplicationStatus status, Sort sort);

}
