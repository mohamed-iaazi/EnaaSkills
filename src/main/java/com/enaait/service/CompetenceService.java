package com.enaait.service;

import com.enaait.model.Competence;
import com.enaait.model.SousCompetence;
import com.enaait.repository.CompetenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetenceService {
    private final CompetenceRepository competenceRepository;

    public CompetenceService(CompetenceRepository competenceRepository) {
        this.competenceRepository = competenceRepository;
    }

    public List<Competence> getAllCompetences() {
        return competenceRepository.findAll();
    }

    public Optional<Competence> getCompetenceById(Long id) {
        return competenceRepository.findById(id);
    }

    public Competence createCompetence(Competence competence) {
        return competenceRepository.save(competence);
    }

    public Competence updateCompetence(Long id, Competence updated) {

    }

    public void deleteCompetence(Long id) {
        competenceRepository.deleteById(id);
    }

    public boolean isCompetenceAcquired(Competence competence) {

    }
} 