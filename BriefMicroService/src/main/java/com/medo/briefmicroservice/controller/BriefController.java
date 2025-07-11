package com.medo.briefmicroservice.controller;


import com.medo.briefmicroservice.dto.Competence;
import com.medo.briefmicroservice.model.Brief;
import com.medo.briefmicroservice.service.BriefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brief")

public class BriefController {

   private  BriefService briefService;


    @Autowired
    public void setBriefService(BriefService briefService) {
        this.briefService = briefService;
    }


    @PostMapping("/create")
    public ResponseEntity<Brief> createNewBrief(@RequestBody Brief brief) {
        return ResponseEntity.ok().body(briefService.createNewBrief(brief).getBody());

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteBrief(@PathVariable Long id) {
        return ResponseEntity.ok().body(briefService.deleteBrief(id).getBody());
    }

    @PutMapping("/update")
    public ResponseEntity<Brief> updateBrief(@RequestBody Brief brief) {
        return ResponseEntity.ok().body(briefService.updateBrief(brief).getBody());
    }

    @GetMapping("/my-brief")
    public ResponseEntity<List<Brief>> getAllBrief() {
        return ResponseEntity.ok(briefService.getAllBriefs().getBody());
    }

    @PostMapping("/associate/{briefId}/{competenceId}")
    public ResponseEntity<Void> competence(@PathVariable Long briefId, @PathVariable Long competenceId) {
        return  briefService.associateCompetence(briefId, competenceId) ;
    }
//
//    @GetMapping
//    public ResponseEntity<List<Competence>> getAllCompetencesAssosiate() {
//
//    }

}
