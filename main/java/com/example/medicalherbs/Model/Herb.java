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
public class Herb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Herb name must not be empty")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String name;

    @NotEmpty(message = "Description must not be empty")
    @Column(columnDefinition = "TEXT NOT NULL")
    private String description;

    @NotEmpty(message = "Optimal season must not be empty")
    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String optimalSeason;

    @Column(columnDefinition = "TEXT")
    private String medicinalUses; // Additional details about medicinal uses
}
