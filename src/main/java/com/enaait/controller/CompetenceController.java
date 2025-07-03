package com.enaait.controller;

import com.enaait.model.Competence;
import com.enaait.service.CompetenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competences")
public class CompetenceController {
    private final CompetenceService competenceService;

    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    @GetMapping
    public List<Competence> getAllCompetences() {

    }

    @GetMapping("/{id}")
    public ResponseEntity<Competence> getCompetenceById(@PathVariable Long id) {

    }

    @PostMapping
    public Competence createCompetence(@RequestBody Competence competence) {
        return competenceService.createCompetence(competence);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competence> updateCompetence(@PathVariable Long id, @RequestBody Competence competence) {

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetence(@PathVariable Long id) {

    }

    @GetMapping("/{id}/acquired")
    public ResponseEntity<Boolean> isCompetenceAcquired(@PathVariable Long id) {

    }
} 