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
public class DrugInteraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Drug name must not be empty")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String drugName;

    @NotEmpty(message = "Interaction details must not be empty")
    @Column(columnDefinition = "TEXT NOT NULL")
    private String interactionDetails;
}
