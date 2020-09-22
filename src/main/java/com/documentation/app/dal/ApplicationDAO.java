package com.documentation.app.dal;

import com.documentation.app.model.Application;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApplicationDAO extends MongoRepository<Application,String>{
    
    
}