package com.enaait.controller;

import com.enaait.model.Competence;
import com.enaait.service.CompetenceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/competences")
@Tag(name = "Gestion des Compétences", description = "API pour gérer les compétences et sous-compétences des apprenants")
public class CompetenceController {



    private final CompetenceService competenceService;
    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }



    @Operation(summary = "Créer ou mettre à jour une compétence avec ses sous-compétences")
    @PostMapping
    public ResponseEntity<Competence> saveCompetence(@RequestBody Competence competence) {
        Competence saved = competenceService.saveCompetence(competence);
        return ResponseEntity.ok(saved);
    }

    @Operation(summary = "Valider ou invalider une sous-compétence")
    @PutMapping("/souscompetences/{id}/valider")
    public ResponseEntity<Void> validerSousCompetence(@PathVariable Long id, @RequestParam boolean valide) {
        competenceService.validerSousCompetence(id, valide);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Supprimer une compétence par son ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetence(@PathVariable Long id) {
        competenceService.deleteCompetence(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Lister toutes les compétences")
    @GetMapping
    public ResponseEntity<List<Competence>> getAllCompetences() {
        List<Competence> competences = competenceService.getAllCompetences();
        return ResponseEntity.ok(competences);
    }
}
