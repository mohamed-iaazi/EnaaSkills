package com.medo.briefmicroservice.service;

import com.medo.briefmicroservice.client.CompetenceClient;
import com.medo.briefmicroservice.dto.Competence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceService {
    @Autowired
    CompetenceClient competenceService;
    public List<Competence> getCompetenceService() {
        return competenceService.findAllCompetences();

    }
}
