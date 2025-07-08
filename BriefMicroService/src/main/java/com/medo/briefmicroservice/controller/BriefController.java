package com.medo.briefmicroservice.controller;


import com.medo.briefmicroservice.model.Brief;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brief")
public class BriefController {


    @PostMapping("/create")
    public ResponseEntity<Brief> createNewBrief(@RequestBody Brief brief) {
        return ResponseEntity.ok().body(brief);

    }
}
