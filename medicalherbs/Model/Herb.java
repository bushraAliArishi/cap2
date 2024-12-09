package com.example.medicalherbs.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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

    @Pattern(regexp = "^(Spring|Summer|Autumn|Winter)$", message = "Optimal season must be Spring, Summer, Autumn, or Winter")
    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String optimalSeason;
}
