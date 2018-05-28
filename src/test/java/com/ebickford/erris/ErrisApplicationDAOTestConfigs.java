package com.ebickford.erris;

import com.ebickford.erris.models.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.io.File;

@TestConfiguration
public class ErrisApplicationDAOTestConfigs {
    
    @Bean
    public IContractDAO getContractDAO() {
        return new InMemoryContractDAO();
    }
    
    @Bean
    @Qualifier("InMemory")
    public IReportDAO getInMemoryReportDAO() {
        return new InMemoryReportDAO();
    }
    
    @Bean
    @Qualifier("File")
    public IReportDAO getFileReportDAO() {
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("EmployeeMasterTestRept.xlsx").getFile());
        
        return new FileReportDAO(file);
    }
    
    @Bean
    public EmployeeContractValidator getEmployeeContractValidator() {
        return new EmployeeContractValidator();
    }
    
    
    
}
