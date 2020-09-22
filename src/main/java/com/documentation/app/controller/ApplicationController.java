package com.documentation.app.controller;

import java.util.List;

import com.documentation.app.dto.ApplicationDto;
import com.documentation.app.service.ApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {
    
    @Autowired
    private ApplicationService applicationService;
    

    @GetMapping
    public ResponseEntity<List<ApplicationDto>> getAllAplicationsDocumentation(){
        List<ApplicationDto> listApplicationDto = applicationService.getAllApplicationsAvailable();
        return new ResponseEntity<>(listApplicationDto,HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ApplicationDto> createApplicationDto(@RequestBody ApplicationDto applicationDto){
        ApplicationDto createdApplication = applicationService.createApplication(applicationDto);
        if(createdApplication!= null){
            return new ResponseEntity<>(createdApplication,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
}