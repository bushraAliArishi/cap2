package com.example.medicalherbs.Controller;

import com.example.medicalherbs.Model.Hospital;
import com.example.medicalherbs.Service.HospitalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hospital")
@RequiredArgsConstructor
public class HospitalController {
    private final HospitalService hospitalService;

    @GetMapping("/getById/{id}")
    public ResponseEntity getHospitalById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(hospitalService.getHospitalById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity getAllHospitals() {
        return ResponseEntity.status(200).body(hospitalService.getAllHospitals());
    }

    @GetMapping("/getByLocation/{location}")
    public ResponseEntity getHospitalsByLocation(@PathVariable String location) {
        return ResponseEntity.status(200).body(hospitalService.getHospitalsByLocation(location));
    }

    @PostMapping("/add")
    public ResponseEntity addHospital(@RequestBody @Valid Hospital hospital) {
        hospitalService.addHospital(hospital);
        return ResponseEntity.status(200).body("Hospital added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateHospital(@PathVariable Integer id, @RequestBody @Valid Hospital hospital) {
        hospitalService.updateHospital(id, hospital);
        return ResponseEntity.status(200).body("Hospital updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteHospital(@PathVariable Integer id) {
        hospitalService.deleteHospital(id);
        return ResponseEntity.status(200).body("Hospital deleted successfully");
    }
}