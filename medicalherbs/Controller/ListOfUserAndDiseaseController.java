package com.example.medicalherbs.Controller;


import com.example.medicalherbs.Model.ListOfUserAndDiseases;
import com.example.medicalherbs.Service.ListOfUserAndDiseaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/listOfUserAndDisease")
@RequiredArgsConstructor
public class ListOfUserAndDiseaseController {
    private final ListOfUserAndDiseaseService service;

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity getAllByUserId(@PathVariable Integer userId) {
        return ResponseEntity.status(200).body(service.getAllByUserId(userId));
    }

    @GetMapping("/getByDiseaseId/{diseaseId}")
    public ResponseEntity getAllByDiseaseId(@PathVariable Integer diseaseId) {
        return ResponseEntity.status(200).body(service.getAllByDiseaseId(diseaseId));
    }

    @PostMapping("/add")
    public ResponseEntity addLink(@RequestBody @Valid ListOfUserAndDiseases link) {
        service.addListOfUserAndDisease(link);
        return ResponseEntity.status(200).body("user has add a disease to the profile");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateLink(@PathVariable Integer id, @RequestBody @Valid ListOfUserAndDiseases link) {
        service.updateListOfUserAndDisease(id, link);
        return ResponseEntity.status(200).body("user has update a disease in  profile");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLink(@PathVariable Integer id) {
        service.deleteListOfUserAndDisease(id);
        return ResponseEntity.status(200).body("user has remove a disease from  profile");
    }
}
