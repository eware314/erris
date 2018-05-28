package com.ebickford.erris;

import com.ebickford.erris.models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ErrisApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ErrisApplication.class, args);
    }
    
    @Bean
    public IContractDAO getContractDAO() {
        return new DatabaseContractDAO();
    }
    
    @Bean
    public IReportDAO getReportDAO() {
        return new FileReportDAO(null);
    }
    
    
}
