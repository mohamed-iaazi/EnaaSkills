package com.medo.competencemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class CompetenceMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompetenceMicroServiceApplication.class, args);
    }

}
