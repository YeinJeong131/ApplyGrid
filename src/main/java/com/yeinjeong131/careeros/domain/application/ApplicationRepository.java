package com.yeinjeong131.careeros.domain.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    Page<Application> findByCompanyNameContainingIgnoreCaseOrPositionTitleContainingIgnoreCaseOrNotesContainingIgnoreCase(String companyKeyword, String positionKeyword, String noteKeyword, Pageable pageable);

    Page<Application> findByStatus(ApplicationStatus status, Pageable pageable);

}
