package org.ibs.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class RestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestDemoApplication.class, args);
    }


}
