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
public class DiseaseInteraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Disease name must not be empty")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String diseaseName;

    @NotEmpty(message = "Interaction details must not be empty")
    @Column(columnDefinition = "TEXT NOT NULL")
    private String interactionDetails;
}
