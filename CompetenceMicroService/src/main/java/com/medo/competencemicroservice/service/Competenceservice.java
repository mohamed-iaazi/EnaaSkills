package com.medo.competencemicroservice.service;


import com.medo.competencemicroservice.model.Competence;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Competenceservice {

    Competence findCompetenceById(Long id);
    List<Competence> findAllCompetences();
    Competence saveCompetence(Competence competence);
    Competence updateCompetence(Competence competence);
    void deleteCompetence(Long id);



}
