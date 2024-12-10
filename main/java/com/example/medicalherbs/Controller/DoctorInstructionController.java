package com.example.medicalherbs.Controller;

import com.example.medicalherbs.Model.DoctorInstruction;
import com.example.medicalherbs.Service.DoctorInstructionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctorInstruction")
@RequiredArgsConstructor
public class DoctorInstructionController {
    private final DoctorInstructionService doctorInstructionService;

    @GetMapping("/getById/{id}")
    public ResponseEntity getInstructionById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(doctorInstructionService.getInstructionById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity getAllInstructions() {
        return ResponseEntity.status(200).body(doctorInstructionService.getAllInstructions());
    }

    @GetMapping("/getByDoctorId/{doctorId}")
    public ResponseEntity getInstructionsByDoctorId(@PathVariable Integer doctorId) {
        return ResponseEntity.status(200).body(doctorInstructionService.getInstructionsByDoctorId(doctorId));
    }

    @GetMapping("/getByCaseHistoryId/{caseHistoryId}")
    public ResponseEntity getInstructionsByCaseHistoryId(@PathVariable Integer caseHistoryId) {
        return ResponseEntity.status(200).body(doctorInstructionService.getInstructionsByCaseHistoryId(caseHistoryId));
    }


    @PostMapping("/add")
    public ResponseEntity addInstruction(@RequestBody @Valid DoctorInstruction instruction) {
        doctorInstructionService.addInstruction(instruction);
        return ResponseEntity.status(200).body("Doctor instruction added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateInstruction(@PathVariable Integer id, @RequestBody @Valid DoctorInstruction instruction) {
        doctorInstructionService.updateInstruction(id, instruction);
        return ResponseEntity.status(200).body("Doctor instruction updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteInstruction(@PathVariable Integer id) {
        doctorInstructionService.deleteInstruction(id);
        return ResponseEntity.status(200).body("Doctor instruction deleted successfully");
    }
}