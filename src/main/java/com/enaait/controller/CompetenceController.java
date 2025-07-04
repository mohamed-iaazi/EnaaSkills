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
@Tag(name = "Competences" , description = "Gestion des compétences et sous-compétences")
public class CompetenceController {
    private final CompetenceService competenceService;

    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }



    @Operation(summary = "access a touts les competences  ")
    @GetMapping
    public List<Competence> getAllCompetences() {


        return  null;
    }



    @Operation(summary = "access a une competence avec id ")
    @GetMapping("/{id}")
    public ResponseEntity<Competence> getCompetenceById(@PathVariable Long id) {
  return null;
    }



    @Operation(summary = "ajouter nouveau competence")
    @PostMapping
    public Competence createCompetence(@RequestBody Competence competence) {
        return competenceService.createCompetence(competence);
    }

    @Operation(summary = "modifier un competence avec une id")
    @PutMapping("/{id}")
    public ResponseEntity<Competence> updateCompetence(@PathVariable Long id, @RequestBody Competence competence) {
 return  null;
    }



    @Operation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetence(@PathVariable Long id) {

        return null;
    }

    @GetMapping("/{id}/acquired")
    public ResponseEntity<Boolean> isCompetenceAcquired(@PathVariable Long id) {

        return null;
    }
} 