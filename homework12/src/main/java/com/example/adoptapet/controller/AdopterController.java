package com.example.adoptapet.controller;

import com.example.adoptapet.model.adopter.Adopter;
import com.example.adoptapet.model.adopter.CreateAdopter;
import com.example.adoptapet.service.AdopterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/adopter")
public class AdopterController {

    @Autowired
    private AdopterService adopterService;

    @Autowired
    URIBuilder uriBuilder;

    @PostMapping
    public ResponseEntity<?> createAdopter(CreateAdopter createAdopter){
        Adopter adopter = this.adopterService.createAdopter(createAdopter);
        URI uri = uriBuilder.getURI(adopter.getId());
        return ResponseEntity.created(uri).body(adopter);
    }

    @GetMapping
    public ResponseEntity<?> getAdopterList(@PathVariable String adopterName, @PathVariable LocalDate dob){
        List<Adopter> adopters = adopterService.getListBy(adopterName, dob);
        return ResponseEntity.ok().body(adopters);
    }

    @GetMapping(("/{id}"))
    public ResponseEntity<?> getById(@PathVariable long id){
        Adopter adopter = adopterService.getById(id);
        return ResponseEntity.ok(adopter);
    }
}
