package com.documentation.app.service;

import java.util.List;

import com.documentation.app.dto.ApplicationDto;

public interface ApplicationService {

    List<ApplicationDto> getAllApplicationsAvailable();

    /*List<String> getAvailableVersionsByApplication(int idApplication);

    List<String> getDocumentationByApplicationAndVersion(int idApplication, String version);*/

    ApplicationDto createApplication(ApplicationDto applicationDto);

    /*ApplicationDto addDocumentationToApllication(int idApplication, DocumentationDto documentationDto);

    ApplicationDto updateDocumentationToApplication(int idApplication, DocumentationDto documentationDto);

    ApplicationDto removeDocumentationToApplication(int idApplication, String verison);

    void deleteApplication(int idApplication);*/

}