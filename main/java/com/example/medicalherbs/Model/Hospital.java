package com.example.medicalherbs.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Hospital name must not be empty")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String name;

    @NotEmpty(message = "Location must not be empty")
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String location;

    @NotNull(message = "Start work hour must not be null")
    @Column(columnDefinition = "TIME NOT NULL")
    private LocalTime startWorkHour;

    @NotNull(message = "Close work hour must not be null")
    @Column(columnDefinition = "TIME NOT NULL")
    private LocalTime closeWorkHour;
}
