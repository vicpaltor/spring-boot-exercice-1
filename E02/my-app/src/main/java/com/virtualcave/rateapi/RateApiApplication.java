package com.virtualcave.rateapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RateApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RateApiApplication.class, args);
    }
}



/*Clase principal de aplicación que inicie Spring Boot.*/