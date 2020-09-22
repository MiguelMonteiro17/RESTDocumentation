package com.documentation.app.model;

public class Documentation {

    private String version;

    private String documentation;

    public Documentation(String version, String documentation){
        this.version = version;
        this.documentation = documentation;
    }

    public String getVersion(){
        return this.version;
    }

    public void setVersion(String version){
        this.version = version;
    }

    public String getDocumentation(){
        return this.documentation;
    }

    public void setDocumentation(String documentation){
        this.documentation = documentation;
    }

}
