package com.example.medicalherbs.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "INT")
    private Integer doctorId;

    @NotNull(message = "User ID must not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer patientId;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL DEFAULT 'Pending'")
    @Pattern(regexp = "^(Pending|Accepted|Rejected)$", message = "Status must be 'Pending', 'Accepted', or 'Rejected'")
    private String status="Pending";

    @NotEmpty(message = "Appointment type must not be empty")
    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String type;

    @Future(message = "Appointment date must be in the future")
    @NotNull(message = "Appointment date must not be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE NOT NULL")
    private LocalDate date;

    @NotNull(message = "Appointment time must not be null")
    @JsonFormat(pattern = "HH:mm:ss")
    @Column(columnDefinition = "TIME NOT NULL")
    private LocalTime time;

    @Column(columnDefinition = "TEXT")
    private String notes;
}