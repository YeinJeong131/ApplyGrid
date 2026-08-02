package com.yeinjeong131.careeros.domain.application;

import com.yeinjeong131.careeros.domain.application.dto.ApplicationUpdateRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    // To create an application record
    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }

    public List<Application> getApplications(Sort sort){
        return applicationRepository.findAll(sort);
    }

    public Application getApplication(Long id) {
        Optional<Application> result = applicationRepository.findById(id);
        Application application = result.orElseThrow(() -> new IllegalArgumentException("Application not found. id=" + id));

        return application;
    }

    public Application updateApplication(Long id, ApplicationUpdateRequest request) {
        Application application = getApplication(id);
        application.update(
                request.getCompanyName(),
                request.getPositionTitle(),
                request.getStatus(),
                request.getAppliedDate(),
                request.getJobUrl(),
                request.getLocation(),
                request.getNotes()
        );
        return application;
    }

    public void deleteApplication(Long id) {
        Application application = getApplication(id);
        applicationRepository.delete(application);
    }

    public List<Application> searchApplications(String keyword, Sort sort) {
        return applicationRepository.findByCompanyNameContainingIgnoreCaseOrPositionTitleContainingIgnoreCaseOrNotesContainingIgnoreCase(keyword, keyword, keyword, sort);
    }

    public List<Application> filterApplicationStatus(ApplicationStatus status, Sort sort) {
        return applicationRepository.findByStatus(status, sort);
    }
}
