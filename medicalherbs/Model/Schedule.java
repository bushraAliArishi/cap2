package com.example.medicalherbs.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Doctor ID must not be empty")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer doctorId;

    @NotEmpty(message = "Stint ID must not be empty")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer stintId;

    @NotEmpty(message = "Schedule date must not be empty")
    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String scheduleDate;
}
