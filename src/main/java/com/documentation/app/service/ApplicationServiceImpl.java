package com.documentation.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.documentation.app.dal.ApplicationDAO;
import com.documentation.app.dto.ApplicationDto;
import com.documentation.app.dto.DocumentationDto;
import com.documentation.app.exceptions.ApplicationNameException;
import com.documentation.app.model.Application;
import com.documentation.app.model.Documentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

    private Logger logger = LoggerFactory.getLogger(ApplicationServiceImpl.class);

    @Autowired
    private ApplicationDAO applicationDAO;
    
    @Override
    public List<ApplicationDto> getAllApplicationsAvailable(){
        List<Application> listApplication = this.applicationDAO.findAll();
        
        List<ApplicationDto> listApplicationDto = new ArrayList<>();
        for(Application application : listApplication){
            List<DocumentationDto> documentationDto = application.getDocumentation().stream()
                                                                                    .map(x -> new DocumentationDto(x.getVersion(),x.getDocumentation()))
                                                                                    .collect(Collectors.toList());
            ApplicationDto applicationDto = new ApplicationDto(application.getId(),application.getName(),documentationDto);
            listApplicationDto.add(applicationDto);
        }                                                 
        return listApplicationDto;                                      
    }

    @Override
    public ApplicationDto createApplication(ApplicationDto applicationDto) {
        try{
            List<Documentation> documentationList = applicationDto.getDocumentations().stream()
                                                                                  .map(x -> new Documentation(x.getVersion(), x.getDocumentation()))
                                                                                  .collect(Collectors.toList());
            Application application = new Application(applicationDto.getApplicationName()); 
            for(Documentation documentation : documentationList){
                application.addDocumentation(documentation);
            }
            application = applicationDAO.save(application);
            List<DocumentationDto> documentationDto = application.getDocumentation().stream()
                                                                                    .map(x -> new DocumentationDto(x.getVersion(), x.getDocumentation()))
                                                                                    .collect(Collectors.toList());
            ApplicationDto returnApplication = new ApplicationDto(application.getId(),application.getName(),documentationDto);
            return returnApplication;
            
        }catch (ApplicationNameException ex){
            logger.error("Error trying to create Application", ex);
            return null;
        }
    }
    
}