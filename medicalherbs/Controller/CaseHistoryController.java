package com.example.medicalherbs.Controller;

import com.example.medicalherbs.Model.CaseHistory;
import com.example.medicalherbs.Service.CaseHistoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/caseHistory")
@RequiredArgsConstructor
public class CaseHistoryController {
    private final CaseHistoryService caseHistoryService;

    @GetMapping("/getById/{id}")
    public ResponseEntity getCaseHistoryById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(caseHistoryService.getCaseHistoryById(id));
    }

    @GetMapping("/getByConflictingType/{conflictingType}")
    public ResponseEntity getCaseHistoriesByConflictingType(@PathVariable String conflictingType) {
        return ResponseEntity.status(200).body(caseHistoryService.getCaseHistoriesByConflictingType(conflictingType));
    }

    @PostMapping("/add")
    public ResponseEntity addCaseHistory(@RequestBody @Valid CaseHistory caseHistory) {
        caseHistoryService.addCaseHistory(caseHistory);
        return ResponseEntity.status(200).body("Case history added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCaseHistory(@PathVariable Integer id, @RequestBody @Valid CaseHistory caseHistory) {
        caseHistoryService.updateCaseHistory(id, caseHistory);
        return ResponseEntity.status(200).body("Case history updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCaseHistory(@PathVariable Integer id) {
        caseHistoryService.deleteCaseHistory(id);
        return ResponseEntity.status(200).body("Case history deleted successfully");
    }

    @PostMapping("/checkHerbConflict")
    public ResponseEntity checkHerbConflict(@RequestParam Integer herbId, @RequestParam Integer conflictingEntityId, @RequestParam String conflictingType) {
        return ResponseEntity.status(200).body(caseHistoryService.checkHerbConflict(herbId, conflictingEntityId, conflictingType));
    }

    @GetMapping("/getConflictsByHerbId/{herbId}")
    public ResponseEntity getConflictsByHerbId(@PathVariable Integer herbId) {
        return ResponseEntity.status(200).body(caseHistoryService.getConflictsByHerbId(herbId));
    }

    @GetMapping("/getConflictsByType/{type}")
    public ResponseEntity getConflictsByType(@PathVariable String type) {
        return ResponseEntity.status(200).body(caseHistoryService.getConflictsByType(type));
    }
}
