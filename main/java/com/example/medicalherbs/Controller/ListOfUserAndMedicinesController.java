package com.example.medicalherbs.Controller;

import com.example.medicalherbs.Model.ListOfUserAndMedicines;
import com.example.medicalherbs.Service.ListOfUserAndMedicinesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/userMedicines")
@RequiredArgsConstructor
public class ListOfUserAndMedicinesController {
    private final ListOfUserAndMedicinesService listOfUserAndMedicinesService;

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity getLinksByUserId(@PathVariable Integer userId) {
        return ResponseEntity.status(200).body(listOfUserAndMedicinesService.getLinksByUserId(userId));
    }

    @GetMapping("/getByMedicineId/{medicineId}")
    public ResponseEntity getLinksByMedicineId(@PathVariable Integer medicineId) {
        return ResponseEntity.status(200).body(listOfUserAndMedicinesService.getLinksByMedicineId(medicineId));
    }

    @PostMapping("/add")
    public ResponseEntity addLink(@RequestBody @Valid ListOfUserAndMedicines link) {
        listOfUserAndMedicinesService.addLink(link);
        return ResponseEntity.status(200).body("Link added successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLink(@PathVariable Integer id) {
        listOfUserAndMedicinesService.deleteLink(id);
        return ResponseEntity.status(200).body("Link deleted successfully");
    }
}