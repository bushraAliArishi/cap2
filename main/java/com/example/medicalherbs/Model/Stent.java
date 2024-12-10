package com.example.medicalherbs.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Stent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Type must not be empty")
    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String type; // e.g., "Heart", "Kidney", etc.

    @NotEmpty(message = "Location must not be empty")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String location;

    @NotNull(message = "User ID must not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer userId;

    @NotEmpty(message = "Details must not be empty")
    @Column(columnDefinition = "TEXT NOT NULL")
    private String details;

    @NotEmpty(message = "Status must not be empty")
    @Column(columnDefinition = "VARCHAR(50) DEFAULT 'active'")
    private String status; // e.g., "Active", "Pending", "Removed"
}
