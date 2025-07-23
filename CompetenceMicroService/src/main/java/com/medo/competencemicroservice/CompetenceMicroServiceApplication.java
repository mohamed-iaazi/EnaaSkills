package com.medo.competencemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CompetenceMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompetenceMicroServiceApplication.class, args);
    }

}
