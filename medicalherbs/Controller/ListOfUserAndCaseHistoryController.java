package com.example.medicalherbs.Controller;

import com.example.medicalherbs.Model.ListOfUserAndCaseHistory;
import com.example.medicalherbs.Service.ListOfUserAndCaseHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userCaseHistory")
@RequiredArgsConstructor
public class ListOfUserAndCaseHistoryController {

    private final ListOfUserAndCaseHistoryService service;

    @PostMapping("/add/{userId}/{caseHistoryId}")
    public ResponseEntity addUserCaseHistory(@PathVariable Integer userId, @PathVariable Integer caseHistoryId) {
        service.addUserCaseHistory(userId, caseHistoryId);
         return  ResponseEntity.status(200).body("this case has been  added to user history");
    }

    @GetMapping("/getCaseHistoriesByUser/{userId}")
    public ResponseEntity getCaseHistoriesByUserId(@PathVariable Integer userId) {
        return ResponseEntity.status(200).body(service.getCaseHistoriesByUserId(userId));
    }

    @GetMapping("/getUsersByCaseHistory/{caseHistoryId}")
    public ResponseEntity getUsersByCaseHistoryId(@PathVariable Integer caseHistoryId) {
        return ResponseEntity.status(200).body( service.getUsersByCaseHistoryId(caseHistoryId));
    }
}
