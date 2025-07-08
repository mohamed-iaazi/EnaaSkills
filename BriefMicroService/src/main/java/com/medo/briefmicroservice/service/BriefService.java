package com.medo.briefmicroservice.service;

import com.medo.briefmicroservice.model.Brief;
import com.medo.briefmicroservice.repository.BriefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BriefService {

    BriefRepository repository;

    @Autowired
    public BriefService(BriefRepository repository) {
        this.repository = repository;
    }



    public void  createNewBrief(Brief brief) {
     repository.save(brief);
    }

}
