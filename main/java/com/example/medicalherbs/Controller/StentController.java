package com.example.medicalherbs.Controller;

import com.example.medicalherbs.Model.Stent;
import com.example.medicalherbs.Service.StentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stent")
@RequiredArgsConstructor
public class StentController {
    private final StentService stentService;

    @GetMapping("/getById/{id}")
    public ResponseEntity getStentById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(stentService.getStentById(id));
    }

    @PostMapping("/add")
    public ResponseEntity addStent(@RequestBody @Valid Stent stent) {
        stentService.addStent(stent);
        return ResponseEntity.status(200).body("Stent added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStent(@PathVariable Integer id, @RequestBody @Valid Stent stent) {
        stentService.updateStent(id, stent);
        return ResponseEntity.status(200).body("Stent updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStent(@PathVariable Integer id) {
        stentService.deleteStent(id);
        return ResponseEntity.status(200).body("Stent deleted successfully");
    }
}
