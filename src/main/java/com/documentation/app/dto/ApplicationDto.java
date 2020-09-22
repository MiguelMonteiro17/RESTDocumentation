package com.documentation.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idApplication;

    private String applicationName;

    private List<DocumentationDto> documentations;

    public ApplicationDto(){
        this.documentations = new ArrayList<>();
    }

    public ApplicationDto(int idApplication, String applicationName,List<DocumentationDto> documentation){
        this();
        setIdApplication(idApplication);
        setApplicationName(applicationName);
        setDocumentations(documentations);
    }

    public int getIdApplication() {
        return idApplication;
    }

    public void setIdApplication(int idApplication) {
        this.idApplication = idApplication;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public List<DocumentationDto> getDocumentations() {
        return documentations;
    }

    public void setDocumentations(List<DocumentationDto> documentations) {
        if(documentations != null && !documentations.isEmpty()){
            this.documentations = documentations;    
        }
    }
    
}