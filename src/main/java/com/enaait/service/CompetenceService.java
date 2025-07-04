package com.enaait.service;

import com.enaait.model.Competence;
import com.enaait.model.SousCompetence;
import com.enaait.repository.CompetenceRepository;
import com.enaait.repository.SousCompetenceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CompetenceService {
    private final CompetenceRepository competenceRepository;
    private final SousCompetenceRepository sousCompetenceRepository;

    public CompetenceService(CompetenceRepository competenceRepository,
                             SousCompetenceRepository sousCompetenceRepository) {
        this.competenceRepository = competenceRepository;
        this.sousCompetenceRepository = sousCompetenceRepository;
    }

    // Créer ou mettre à jour une compétence (avec ses sous-compétences)
    public Competence saveCompetence(Competence competence) {
        for (SousCompetence sc : competence.getSousCompetences()) {
            sc.setCompetence(competence);
        }
        competence.setValide(isCompetenceValide(competence));
        return competenceRepository.save(competence);
    }

    // Modifier le statut d'une sous-compétence et mettre à jour la compétence parente
    public void validerSousCompetence(Long sousCompId, boolean valide) {
        SousCompetence sc = sousCompetenceRepository.findById(sousCompId).orElse(null);
        if (sc != null) {
            sc.setValide(valide);
            sousCompetenceRepository.save(sc);

            Competence competence = sc.getCompetence();
            competence.setValide(isCompetenceValide(competence));
            competenceRepository.save(competence);
        }
    }

    // Calcul simple : compétence validée si toutes les sous-compétences le sont
    private boolean isCompetenceValide(Competence competence) {
        for (SousCompetence sc : competence.getSousCompetences()) {
            if (!sc.isValide()) {
                return false;
            }
        }
        return true;
    }

    // Supprimer une compétence
    public void deleteCompetence(Long competenceId) {
        competenceRepository.deleteById(competenceId);
    }

    // Récupérer toutes les compétences
    public List<Competence> getAllCompetences() {
        return competenceRepository.findAll();
    }
} 