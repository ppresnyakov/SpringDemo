package org.ibs.service.config;

import lombok.extern.slf4j.Slf4j;
import org.ibs.service.bussines.GreetingsService;
import org.ibs.service.bussines.GreetingsServiceImpl;
import org.ibs.service.bussines.GreetingsServiceImpl2;
import org.ibs.service.domain.entity.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Slf4j
public class GreetingsServiceConfig {

    @Bean
    @Profile("!test")
    GreetingsService getGSImpl(){
        return new GreetingsServiceImpl(log);
    }


    @Bean
    @Profile("test")
    GreetingsService getGSImpl2(){
        return new GreetingsServiceImpl2(log);
    }



}
