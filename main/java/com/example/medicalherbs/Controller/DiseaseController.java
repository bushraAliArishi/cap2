package com.example.medicalherbs.Controller;

import com.example.medicalherbs.Model.Disease;
import com.example.medicalherbs.Service.DiseaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/disease")
@RequiredArgsConstructor
public class DiseaseController {
    private final DiseaseService diseaseService;

    @GetMapping("/getById/{id}")
    public ResponseEntity getDiseaseById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(diseaseService.getDiseaseById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity getAllDiseases() {
        return ResponseEntity.status(200).body(diseaseService.getAllDiseases());
    }

    @PostMapping("/add")
    public ResponseEntity addDisease(@RequestBody @Valid Disease disease) {
        diseaseService.addDisease(disease);
        return ResponseEntity.status(200).body("Disease added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDisease(@PathVariable Integer id, @RequestBody @Valid Disease disease) {
        diseaseService.updateDisease(id, disease);
        return ResponseEntity.status(200).body("Disease updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDisease(@PathVariable Integer id) {
        diseaseService.deleteDisease(id);
        return ResponseEntity.status(200).body("Disease deleted successfully");
    }
}