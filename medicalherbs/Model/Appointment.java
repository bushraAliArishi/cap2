package com.example.medicalherbs.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Doctor ID must not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer doctorId;

    @NotNull(message = "User ID must not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer userId;

    @NotEmpty(message = "Appointment type must not be empty")
    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String type;

    @Future(message = "Appointment date must be in the future")
    @NotNull(message = "Appointment date must not be null")
    @Column(columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime date;

    @Column(columnDefinition = "TEXT")
    private String notes;
}
