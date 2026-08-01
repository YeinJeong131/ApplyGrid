package com.yeinjeong131.careeros.domain.application;

import org.springframework.stereotype.Service;

import java.util.List;

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
}
