package com.example.medicalherbs.Controller;

import com.example.medicalherbs.Model.Doctor;
import com.example.medicalherbs.Service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("/getById/{id}")
    public ResponseEntity getDoctorById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(doctorService.getDoctorById(id));
    }

    @GetMapping("/getBySpecialization/{specialization}")
    public ResponseEntity getDoctorsBySpecialization(@PathVariable String specialization) {
        return ResponseEntity.status(200).body(doctorService.getDoctorsBySpecialization(specialization));
    }

    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody @Valid Doctor doctor) {
        doctorService.addDoctor(doctor);
        return ResponseEntity.status(200).body("Doctor added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDoctor(@PathVariable Integer id, @RequestBody @Valid Doctor doctor) {
        doctorService.updateDoctor(id, doctor);
        return ResponseEntity.status(200).body("Doctor updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDoctor(@PathVariable Integer id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.status(200).body("Doctor deleted successfully");
    }
}
