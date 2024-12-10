package com.example.medicalherbs.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "time NOT NULL")
    @NotNull(message = "Start time is required")
    private LocalTime startTime;

    @Column(columnDefinition = "time NOT NULL")
    @NotNull(message = "End time is required")
    private LocalTime endTime;

    @NotNull(message = "Doctor ID must not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer doctorId;
}
