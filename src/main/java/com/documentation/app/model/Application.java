package com.documentation.app.model;

import java.util.List;

public class Application {

    private int id;

    private String name;

    private List<Documentation> documentation;

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Documentation> getDocumentation(){
        return this.documentation;
    }

    public void setDocumentation(List<Documentation> documentation){
        this.documentation = documentation;
    }
}
