package com.documentation.app.exceptions;

public class ApplicationNameException extends Exception{

    private static final long serialVersionUID = 1L;

    public ApplicationNameException(){
        super("Application name can't be null");
    }

}