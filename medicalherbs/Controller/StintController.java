package com.example.medicalherbs.Controller;

import com.example.medicalherbs.Model.Stint;
import com.example.medicalherbs.Service.StintService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stint")
@RequiredArgsConstructor
public class StintController {
    private final StintService stintService;

    @GetMapping("/getById/{id}")
    public ResponseEntity getStintById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(stintService.getStintById(id));
    }

    @GetMapping("/getByStatus/{status}")
    public ResponseEntity getStintsByStatus(@PathVariable String status) {
        return ResponseEntity.status(200).body(stintService.getStintsByStatus(status));
    }

    @GetMapping("/getByTypeAndLocation")
    public ResponseEntity getStintsByTypeAndLocation(@RequestParam String type, @RequestParam String location) {
        return ResponseEntity.status(200).body(stintService.getStintsByTypeAndLocation(type, location));
    }

    @PostMapping("/add")
    public ResponseEntity addStint(@RequestBody @Valid Stint stint) {
        stintService.addStint(stint);
        return ResponseEntity.status(200).body("Stint added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStint(@PathVariable Integer id, @RequestBody @Valid Stint stint) {
        stintService.updateStint(id, stint);
        return ResponseEntity.status(200).body("Stint updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStint(@PathVariable Integer id) {
        stintService.deleteStint(id);
        return ResponseEntity.status(200).body("Stint deleted successfully");
    }
}
