package com.assessment.configuration;

import com.assessment.service.CarsService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurations {
        
    @Bean
    public CarsService carService(){

        return new CarsService();
    }
}
