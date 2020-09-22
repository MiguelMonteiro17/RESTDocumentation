package com.documentation.app.model;

import java.util.ArrayList;
import java.util.List;

import com.documentation.app.exceptions.ApplicationNameException;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="applications")
public class Application {

    @Id
    private int id;

    private String name;

    private List<Documentation> documentation;

    public Application(String name)throws ApplicationNameException{
        setName(name);
        this.documentation = new ArrayList<>();
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) throws ApplicationNameException {
        if(name!=null){
            this.name = name;    
        }else{
            throw new ApplicationNameException();
        }
    }

    public List<Documentation> getDocumentation(){
        return this.documentation;
    }

    public void addDocumentation(Documentation documentation){
        this.documentation.add(documentation);
    }

    @Override
    public String toString(){
        return  String.format("Application id = %d, name = %s and available documentations = %s", id,name,documentation.toString());
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int result = 1;
        result = prime * result + ((documentation == null) ? 0 : documentation.hashCode());
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Application other = (Application) obj;
        if (documentation == null) {
            if (other.documentation != null){
                return false;
            }
        } else if (!documentation.equals(other.documentation))
            return false;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    
}
