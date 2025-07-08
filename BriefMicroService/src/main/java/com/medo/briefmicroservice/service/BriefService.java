package com.medo.briefmicroservice.service;

import com.medo.briefmicroservice.model.Brief;
import com.medo.briefmicroservice.repository.BriefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BriefService {

    BriefRepository repository;

    @Autowired
    public BriefService(BriefRepository repository) {
        this.repository = repository;
    }


    public ResponseEntity<Brief> createNewBrief(Brief brief) {

        if (repository.existsById(brief.getId())) {
            repository.save(brief);
            return   ResponseEntity.ok().body(brief);

        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Brief> updateBrief(Brief brief) {
        if (repository.existsById(brief.getId())) {

            repository.save(brief);
            return   ResponseEntity.ok().body(brief);

        }
            return ResponseEntity.notFound().build();

    }

    public ResponseEntity<Brief> deleteBrief(Brief brief) {
        repository.delete(brief);
        return ResponseEntity.ok().body(brief);
    }


    public ResponseEntity<List<Brief>> getAllBriefs() {
        List<Brief> briefs = repository.findAll();
        return ResponseEntity.ok().body(briefs);
    }

}
