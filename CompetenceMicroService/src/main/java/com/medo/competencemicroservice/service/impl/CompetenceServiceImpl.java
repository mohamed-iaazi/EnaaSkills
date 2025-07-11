package com.medo.competencemicroservice.service.impl;

import com.medo.competencemicroservice.model.Competence;
import com.medo.competencemicroservice.repository.CompetenceRepository;
import com.medo.competencemicroservice.service.Competenceservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompetenceServiceImpl implements Competenceservice {

    @Autowired
    CompetenceRepository competenceRepository;

    @Override
    public Competence findCompetenceById(Long id) {
        return competenceRepository.findById(String.valueOf(id)).orElse(null);
    }

    @Override
    public List<Competence> findAllCompetences() {
        return competenceRepository.findAll();
    }

    @Override
    public Competence saveCompetence(Competence competence) {
        return competenceRepository.save(competence);
    }

    @Override
    public Competence updateCompetence(Competence competence) {
        return competenceRepository.save(competence);
    }



    @Override
    public void deleteCompetence(Long id) {

        competenceRepository.deleteById(String.valueOf(id));

    }
}
