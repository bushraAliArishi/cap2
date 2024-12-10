package com.example.medicalherbs.Controller;

import com.example.medicalherbs.Model.Appointment;
import com.example.medicalherbs.Model.Patient;
import com.example.medicalherbs.Service.AppointmentService;
import com.example.medicalherbs.Service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    private final AppointmentService appointmentService;

    @GetMapping("/getById/{id}")
    public ResponseEntity getPatientById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(patientService.getPatientById(id));
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity getPatientByEmail(@PathVariable String email) {
        return ResponseEntity.status(200).body(patientService.getPatientByEmail(email));
    }

    @PostMapping("/add")
    public ResponseEntity addPatient(@RequestBody @Valid Patient patient) {
        patientService.addPatient(patient);
        return ResponseEntity.status(200).body("Patient added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePatient(@PathVariable Integer id, @RequestBody @Valid Patient patient) {
        patientService.updatePatient(id, patient);
        return ResponseEntity.status(200).body("Patient updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePatient(@PathVariable Integer id) {
        patientService.deletePatient(id);
        return ResponseEntity.status(200).body("Patient deleted successfully");
    }

    @PostMapping("/requestAppointment/{patientId}")
    public ResponseEntity requestAppointmentForPatient(@RequestBody @Valid Appointment appointment, @PathVariable Integer patientId) {
        patientService.requestAppointmentForPatient(appointment, patientId);
        return ResponseEntity.status(200).body("Appointment requested successfully");
    }
}