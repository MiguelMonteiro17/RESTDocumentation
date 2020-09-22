package com.documentation.app.dto;

import java.io.Serializable;

public class DocumentationDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String version;

    private String documentation;

    public DocumentationDto(){

    }

    public DocumentationDto(String version, String documentation){
        setVersion(version);
        setDocumentation(documentation);
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    
    
}