package com.example.medicalherbs.Controller;

import com.example.medicalherbs.Model.ListOfUserAndMedicines;
import com.example.medicalherbs.Service.ListOfUserAndDrugService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/listOfUserAndDrug")
@RequiredArgsConstructor
public class ListOfUserAndDrugController {
    private final ListOfUserAndDrugService service;

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity getAllByUserId(@PathVariable Integer userId) {
        return ResponseEntity.status(200).body( service.getAllByUserId(userId));
    }

    @GetMapping("/getByDrugId/{drugId}")
    public ResponseEntity getAllByDrugId(@PathVariable Integer drugId) {
        return ResponseEntity.status(200).body(service.getAllByDrugId(drugId));
    }

    @PostMapping("/add")
    public ResponseEntity addLink(@RequestBody @Valid ListOfUserAndMedicines link) {
        service.addListOfUserAndDrug(link);
        return ResponseEntity.status(200).body("user has add a medicine to the profile");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateLink(@PathVariable Integer id, @RequestBody @Valid ListOfUserAndMedicines link) {
        service.updateListOfUserAndDrug(id, link);
        return ResponseEntity.status(200).body("user has update a medicine in profile");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLink(@PathVariable Integer id) {
        service.deleteListOfUserAndDrug(id);
        return ResponseEntity.status(200).body("user has remove a medicine form profile");
    }
}
