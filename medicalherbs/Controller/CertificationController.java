package com.example.medicalherbs.Controller;

import com.example.medicalherbs.Model.Certification;
import com.example.medicalherbs.Service.CertificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/certification")
@RequiredArgsConstructor
public class CertificationController {
    private final CertificationService certificationService;

    @GetMapping("/getById/{id}")
    public ResponseEntity getCertificationById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(certificationService.getCertificationById(id));
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity getCertificationByName(@PathVariable String name) {
        return ResponseEntity.status(200).body(certificationService.getCertificationByName(name));
    }

    @PostMapping("/add")
    public ResponseEntity addCertification(@RequestBody @Valid Certification certification) {
        certificationService.addCertification(certification);
        return ResponseEntity.status(200).body("Certification added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCertification(@PathVariable Integer id, @RequestBody @Valid Certification certification) {
        certificationService.updateCertification(id, certification);
        return ResponseEntity.status(200).body("Certification updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCertification(@PathVariable Integer id) {
        certificationService.deleteCertification(id);
        return ResponseEntity.status(200).body("Certification deleted successfully");
    }
}
