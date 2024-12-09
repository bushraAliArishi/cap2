package com.example.medicalherbs.Controller;

import com.example.medicalherbs.Model.DrugInteraction;
import com.example.medicalherbs.Service.DrugInteractionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/drugInteraction")
@RequiredArgsConstructor
public class DrugInteractionController {
    private final DrugInteractionService drugInteractionService;

    @GetMapping("/getById/{id}")
    public ResponseEntity getDrugInteractionById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(drugInteractionService.getDrugInteractionById(id));
    }

    @GetMapping("/getByDrugName/{name}")
    public ResponseEntity getDrugInteractionByDrugName(@PathVariable String name) {
        return ResponseEntity.status(200).body(drugInteractionService.getDrugInteractionByDrugName(name));
    }

    @PostMapping("/add")
    public ResponseEntity addDrugInteraction(@RequestBody @Valid DrugInteraction drugInteraction) {
        drugInteractionService.addDrugInteraction(drugInteraction);
        return ResponseEntity.status(200).body("Drug interaction added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDrugInteraction(@PathVariable Integer id, @RequestBody @Valid DrugInteraction drugInteraction) {
        drugInteractionService.updateDrugInteraction(id, drugInteraction);
        return ResponseEntity.status(200).body("Drug interaction updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDrugInteraction(@PathVariable Integer id) {
        drugInteractionService.deleteDrugInteraction(id);
        return ResponseEntity.status(200).body("Drug interaction deleted successfully");
    }
}
