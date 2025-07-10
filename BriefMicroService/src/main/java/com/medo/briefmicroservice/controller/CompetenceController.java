package com.medo.briefmicroservice.controller;


import com.medo.briefmicroservice.dto.Competence;
import com.medo.briefmicroservice.service.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/association")
public class CompetenceController {
    @Autowired
    private CompetenceService competenceService;

    @GetMapping
    public List<Competence> competence() {
        return  competenceService.getCompetenceService();

    }
}
