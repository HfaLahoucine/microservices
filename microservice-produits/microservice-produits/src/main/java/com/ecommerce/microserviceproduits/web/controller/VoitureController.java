package com.ecommerce.microserviceproduits.web.controller;

import com.ecommerce.microserviceproduits.web.exceptions.ProductNotFoundException;
import com.ecommerce.microserviceproduits.model.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.ecommerce.microserviceproduits.repository.VoitureRepository;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RestController

public class VoitureController {

    @Autowired
    VoitureRepository voitureRepository;

    // Get All Voitures
    @GetMapping("/voitures")
    public List<Voiture> getAllVoitures() {
        return voitureRepository.findAll();
    }

    // Create a new Voiture
    @PostMapping("/voitures")
    public Voiture createVoiture(@Valid @RequestBody Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    // Get a Single Voiture
    @GetMapping("/voitures/{id}")
    public Voiture getVoitureById(@PathVariable(value = "id") Long VoitureId) {
        return voitureRepository.findById(VoitureId).orElseThrow(() -> new ProductNotFoundException("Voiture", "id", VoitureId));
    }

    // Update a Voiture
    @PutMapping("/voitures/{id}")
    public Voiture updateVoiture(@PathVariable(value = "id") Long VoitureId,@Valid @RequestBody Voiture voitureDetails) {

        Voiture voiture = voitureRepository.findById(VoitureId).orElseThrow(() -> new ProductNotFoundException("Voiture", "id", VoitureId));

        voiture.setTitre(voitureDetails.getTitre());
        voiture.setDescription(voitureDetails.getDescription());

        Voiture updatedVoiture = voitureRepository.save(voiture);
        return updatedVoiture;
    }
    // Delete a Voiture
    @DeleteMapping("/voitures/{id}")
    public ResponseEntity<?> deleteVoiture(@PathVariable(value = "id") Long voitureId) {
        Voiture voiture = voitureRepository.findById(voitureId).orElseThrow(() -> new ProductNotFoundException("Voiture", "id", voitureId));

        voitureRepository.delete(voiture);

        return ResponseEntity.ok().build();
    }
}
