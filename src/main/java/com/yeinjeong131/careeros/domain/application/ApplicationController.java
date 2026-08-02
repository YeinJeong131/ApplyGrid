package com.yeinjeong131.careeros.domain.application;

import com.yeinjeong131.careeros.domain.application.dto.ApplicationCreateRequest;
import com.yeinjeong131.careeros.domain.application.dto.ApplicationResponse;
import com.yeinjeong131.careeros.domain.application.dto.ApplicationUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
    private final ApplicationService applicationService;
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ResponseEntity<ApplicationResponse> createApplication(@RequestBody ApplicationCreateRequest request){
        Application saved = applicationService.createApplication(request.toEntity());
        return ResponseEntity.status(201).body(new ApplicationResponse(saved));
    }

    @GetMapping
    public ResponseEntity<List<ApplicationResponse>> getApplications(
            @RequestParam(required = false) String keyword
    ){
        List<Application> applications;

        if (keyword != null && !keyword.isBlank()) {
            applications = applicationService.searchApplications(keyword);
        } else {
            applications = applicationService.getApplications();
        }

        List<ApplicationResponse> response = applications.stream()
                .map(ApplicationResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationResponse> getApplication(@PathVariable Long id){
        Application application = applicationService.getApplication(id);
        return ResponseEntity.ok(new ApplicationResponse(application));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicationResponse> updateApplication(
            @PathVariable Long id,
            @RequestBody ApplicationUpdateRequest request) {
        Application updated  = applicationService.updateApplication(id, request);
        return ResponseEntity.ok(new ApplicationResponse(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }

}
