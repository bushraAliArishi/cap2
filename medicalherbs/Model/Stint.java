package com.example.medicalherbs.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Stint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = "^(Heart|Kidney|Lung|Vessel)$", message = "Type must be Heart, Kidney, Lung, or Vessel")
    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String type;

    @NotEmpty(message = "Location must not be empty")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String location;

    @NotEmpty(message = "Details must not be empty")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String details;

    @Pattern(regexp = "^(Active|Pending|Removed)$", message = "Status must be Active, Pending, or Removed")
    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String status;

}
