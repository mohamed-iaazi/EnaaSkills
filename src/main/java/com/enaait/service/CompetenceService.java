package com.enaait.service;

import com.enaait.model.Competence;
import com.enaait.model.SousCompetence;
import com.enaait.repository.CompetenceRepository;
import com.enaait.repository.SousCompetenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceService {

    private final CompetenceRepository competenceRepository;
    private final SousCompetenceRepository sousCompetenceRepository;

    public CompetenceService(CompetenceRepository competenceRepository,
                             SousCompetenceRepository sousCompetenceRepository) {
        this.competenceRepository = competenceRepository;
        this.sousCompetenceRepository = sousCompetenceRepository;
    }

    // Save or update a competence (with its sous-competences)
    public Competence saveCompetence(Competence competence) {
        return competenceRepository.save(competence);
    }

    // Validate or invalidate a sous-competence by ID
    public void validerSousCompetence(Long sousCompId, boolean valide) {
        sousCompetenceRepository.findById(sousCompId).ifPresent(sc -> {
            sc.setValide(valide);
            sousCompetenceRepository.save(sc);
        });
    }

    // Delete competence by ID
    public void deleteCompetence(Long competenceId) {
        competenceRepository.deleteById(competenceId);
    }

    // Get all competences
    public List<Competence> getAllCompetences() {
        return competenceRepository.findAll();
    }
}
