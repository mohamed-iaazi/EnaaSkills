package com.medo.briefmicroservice.service;

import com.medo.briefmicroservice.client.CompetenceClient;
import com.medo.briefmicroservice.model.Brief;
import com.medo.briefmicroservice.model.BriefCompetances;
import com.medo.briefmicroservice.repository.BriefRepository;
import com.medo.briefmicroservice.repository.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BriefService {

    BriefRepository repository;
    CompetenceClient competenceClient;
    CompetenceRepository competenceRepository;

    @Autowired
    public BriefService(BriefRepository repository , CompetenceClient competenceClient, CompetenceRepository competenceRepository) {
        this.repository = repository;
        this.competenceClient = competenceClient;
        this.competenceRepository = competenceRepository;
    }


    public ResponseEntity<Brief> createNewBrief(Brief brief) {


            repository.save(brief);
            return   ResponseEntity.ok().body(brief);

    }

    public ResponseEntity<Brief> updateBrief(Brief brief) {
        if (repository.existsById(brief.getId())) {

            repository.save(brief);
            return   ResponseEntity.ok().body(brief);

        }
            return ResponseEntity.notFound().build();

    }

    public ResponseEntity<Boolean> deleteBrief(Long id) {
        if (repository.existsById(id)) {

            repository.deleteById(id);
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.badRequest().body(false);

    }


    public ResponseEntity<List<Brief>> getAllBriefs() {
        List<Brief> briefs = repository.findAll();
        return ResponseEntity.ok().body(briefs);
    }


    public ResponseEntity<Brief> getBrief(Long id) {
        if (repository.existsById(id)) {
            Brief brief = repository.findById(id).get();
            return ResponseEntity.ok().body(brief);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Void> associateCompetence(Long CompetenceId, Long briefId) {
        if (getBrief(briefId) != null && competenceClient.findCompetenceById(CompetenceId)  != null) {


            BriefCompetances briefCompetances= new BriefCompetances();
            briefCompetances.setCompetenceId(CompetenceId);
            briefCompetances.setBrief(getBrief(briefId).getBody());
            competenceRepository.save(briefCompetances);



        }
        return null;
    }

}
