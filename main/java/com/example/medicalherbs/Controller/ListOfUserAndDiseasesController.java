package com.example.medicalherbs.Controller;

import com.example.medicalherbs.Model.ListOfUserAndDiseases;
import com.example.medicalherbs.Service.ListOfUserAndDiseasesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/userDiseases")
@RequiredArgsConstructor
public class ListOfUserAndDiseasesController {
    private final ListOfUserAndDiseasesService listOfUserAndDiseasesService;

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity getLinksByUserId(@PathVariable Integer userId) {
        return ResponseEntity.status(200).body(listOfUserAndDiseasesService.getLinksByUserId(userId));
    }

    @GetMapping("/getByDiseaseId/{diseaseId}")
    public ResponseEntity getLinksByDiseaseId(@PathVariable Integer diseaseId) {
        return ResponseEntity.status(200).body(listOfUserAndDiseasesService.getLinksByDiseaseId(diseaseId));
    }

    @PostMapping("/add")
    public ResponseEntity addLink(@RequestBody @Valid ListOfUserAndDiseases link) {
        listOfUserAndDiseasesService.addLink(link);
        return ResponseEntity.status(200).body("Link added successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLink(@PathVariable Integer id) {
        listOfUserAndDiseasesService.deleteLink(id);
        return ResponseEntity.status(200).body("Link deleted successfully");
    }
}