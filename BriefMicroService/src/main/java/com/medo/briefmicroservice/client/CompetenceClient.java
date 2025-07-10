package com.medo.briefmicroservice.client;


import com.medo.briefmicroservice.dto.Competence;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "competence" , url = "http://localhost:8080/Competence")
public interface CompetenceClient {


    @GetMapping("/afficher")
     List<Competence> findAllCompetences();


}
