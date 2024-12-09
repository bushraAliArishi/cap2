package com.example.medicalherbs.Controller;

import com.example.medicalherbs.Model.Herb;
import com.example.medicalherbs.Service.HerbService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/herb")
@RequiredArgsConstructor
public class HerbController {
    private final HerbService herbService;

    @GetMapping("/getById/{id}")
    public ResponseEntity getHerbById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(herbService.getHerbById(id));
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity getHerbByName(@PathVariable String name) {
        return ResponseEntity.status(200).body(herbService.getHerbByName(name));
    }

    @PostMapping("/add")
    public ResponseEntity addHerb(@RequestBody @Valid Herb herb) {
        herbService.addHerb(herb);
        return ResponseEntity.status(200).body("Herb added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateHerb(@PathVariable Integer id, @RequestBody @Valid Herb herb) {
        herbService.updateHerb(id, herb);
        return ResponseEntity.status(200).body("Herb updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteHerb(@PathVariable Integer id) {
        herbService.deleteHerb(id);
        return ResponseEntity.status(200).body("Herb deleted successfully");
    }
}
