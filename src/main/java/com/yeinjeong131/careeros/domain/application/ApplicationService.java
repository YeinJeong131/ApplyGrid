package com.yeinjeong131.careeros.domain.application;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    // To create an application record
    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }

    public List<Application> getApplications(){
        return applicationRepository.findAll();
    }

    public Application getApplication(Long id) {
        Optional<Application> result = applicationRepository.findById(id);
        Application application = result.orElseThrow(() -> new IllegalArgumentException("Application not found. id=" + id));

        return application;
    }
}
