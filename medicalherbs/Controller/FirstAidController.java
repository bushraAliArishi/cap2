package com.example.medicalherbs.Controller;

import com.example.medicalherbs.Model.FirstAid;
import com.example.medicalherbs.Service.FirstAidService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/firstAid")
@RequiredArgsConstructor
public class FirstAidController {
    private final FirstAidService firstAidService;

    @GetMapping("/getById/{id}")
    public ResponseEntity getFirstAidById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(firstAidService.getFirstAidById(id));
    }

    @GetMapping("/getByCondition/{condition}")
    public ResponseEntity getFirstAidsByCondition(@PathVariable String condition) {
        return ResponseEntity.status(200).body(firstAidService.getFirstAidByCondition(condition));
    }

    @PostMapping("/add")
    public ResponseEntity addFirstAid(@RequestBody @Valid FirstAid firstAid) {
        firstAidService.addFirstAid(firstAid);
        return ResponseEntity.status(200).body("First aid added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateFirstAid(@PathVariable Integer id, @RequestBody @Valid FirstAid firstAid) {
        firstAidService.updateFirstAid(id, firstAid);
        return ResponseEntity.status(200).body("First aid updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteFirstAid(@PathVariable Integer id) {
        firstAidService.deleteFirstAid(id);
        return ResponseEntity.status(200).body("First aid deleted successfully");
    }
}
