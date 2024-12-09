package com.example.medicalherbs.Controller;

import com.example.medicalherbs.Model.DiseaseInteraction;
import com.example.medicalherbs.Service.DiseaseInteractionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/diseaseInteraction")
@RequiredArgsConstructor
public class DiseaseInteractionController {
    private final DiseaseInteractionService diseaseInteractionService;

    @GetMapping("/getById/{id}")
    public ResponseEntity getDiseaseInteractionById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(diseaseInteractionService.getDiseaseInteractionById(id));
    }

    @GetMapping("/getByDiseaseName/{name}")
    public ResponseEntity getDiseaseInteractionByDiseaseName(@PathVariable String name) {
        return ResponseEntity.status(200).body(diseaseInteractionService.getDiseaseInteractionByDiseaseName(name));
    }

    @PostMapping("/add")
    public ResponseEntity addDiseaseInteraction(@RequestBody @Valid DiseaseInteraction diseaseInteraction) {
        diseaseInteractionService.addDiseaseInteraction(diseaseInteraction);
        return ResponseEntity.status(200).body("Disease interaction added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDiseaseInteraction(@PathVariable Integer id, @RequestBody @Valid DiseaseInteraction diseaseInteraction) {
        diseaseInteractionService.updateDiseaseInteraction(id, diseaseInteraction);
        return ResponseEntity.status(200).body("Disease interaction updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDiseaseInteraction(@PathVariable Integer id) {
        diseaseInteractionService.deleteDiseaseInteraction(id);
        return ResponseEntity.status(200).body("Disease interaction deleted successfully");
    }
}
