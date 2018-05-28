package com.ebickford.erris;

import com.ebickford.erris.models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@TestConfiguration
public class ErrisApplicationTestConfigs {
    
    @Bean
    public IContractDAO getContractDAO() {
        return new InMemoryContractDAO();
    }
    
    @Bean
    public IReportDAO getReportDAO() {
        return new InMemoryReportDAO();
    }
    
    @Bean
    public EmployeeContractValidator getEmployeeContractValidator() {
        return new EmployeeContractValidator();
    }
    
    
    
}
