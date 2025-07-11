package com.medo.briefmicroservice.client;


import com.medo.briefmicroservice.dto.Competence;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "competence" , url = "http://localhost:8080/Competence")
public interface CompetenceClient {


    @GetMapping("/afficher/{id}")
     Competence findCompetenceById(@PathVariable  Long id) ;

}
