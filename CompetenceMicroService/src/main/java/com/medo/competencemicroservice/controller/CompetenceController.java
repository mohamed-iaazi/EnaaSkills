package com.medo.competencemicroservice.controller;

import com.medo.competencemicroservice.model.Competence;
import com.medo.competencemicroservice.service.Competenceservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

@RestController
@RequestMapping("Competence/")
public class CompetenceController  {


    @Autowired
    private Competenceservice competenceservice;


    @GetMapping("/afficher/{id}")
    public Competence findCompetenceById(@PathVariable  Long id) {
        return competenceservice.findCompetenceById(id);
    }


    @GetMapping("/afficher")

    public List<Competence> findAllCompetences() {
        return competenceservice.findAllCompetences();
    }


    @PostMapping("/ajouter")

    public Competence saveCompetence(@RequestBody  Competence competence) {
        return competenceservice.saveCompetence(competence);
    }


    @PutExchange("/modifier")
    public Competence updateCompetence(@RequestBody  Competence competence) {
        return competenceservice.saveCompetence(competence);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteCompetence(@PathVariable Long id) {

    }
}
