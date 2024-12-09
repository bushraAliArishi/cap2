package com.example.medicalherbs.Controller;

import com.example.medicalherbs.Model.ListOfCaseHistoryAndFirstAid;
import com.example.medicalherbs.Service.ListOfCaseHistoryAndFirstAidService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/listOfCaseHistoryAndFirstAid")
@RequiredArgsConstructor
public class ListOfCaseHistoryAndFirstAidController {
    private final ListOfCaseHistoryAndFirstAidService listOfCaseHistoryAndFirstAidService;

    @GetMapping("/getById/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(listOfCaseHistoryAndFirstAidService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity getAllRecords() {
        return ResponseEntity.status(200).body(listOfCaseHistoryAndFirstAidService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addRecord(@RequestBody @Valid ListOfCaseHistoryAndFirstAid record) {
        listOfCaseHistoryAndFirstAidService.addRecord(record);
        return ResponseEntity.status(200).body("Record added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateRecord(@PathVariable Integer id, @RequestBody @Valid ListOfCaseHistoryAndFirstAid updatedRecord) {
        listOfCaseHistoryAndFirstAidService.updateRecord(id, updatedRecord);
        return ResponseEntity.status(200).body("Record updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRecord(@PathVariable Integer id) {
        listOfCaseHistoryAndFirstAidService.deleteRecord(id);
        return ResponseEntity.status(200).body("Record deleted successfully");
    }
}
