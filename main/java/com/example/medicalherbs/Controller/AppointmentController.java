package com.example.medicalherbs.Controller;

import com.example.medicalherbs.Model.Appointment;
import com.example.medicalherbs.Service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/getById/{id}")
    public ResponseEntity getAppointmentById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(appointmentService.getAppointmentById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity getAllAppointments() {
        return ResponseEntity.status(200).body(appointmentService.getAllAppointments());
    }

    @PostMapping("/add")
    public ResponseEntity addAppointment(@RequestBody @Valid Appointment appointment) {
        appointmentService.addAppointment(appointment);
        return ResponseEntity.status(200).body("Appointment added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateAppointment(@PathVariable Integer id, @RequestBody @Valid Appointment appointment) {
        appointmentService.updateAppointment(id, appointment);
        return ResponseEntity.status(200).body("Appointment updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAppointment(@PathVariable Integer id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.status(200).body("Appointment deleted successfully");
    }
}