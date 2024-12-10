package com.example.medicalherbs.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Medicine name must not be empty")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String name;

    @NotEmpty(message = "Description must not be empty")
    @Column(columnDefinition = "TEXT NOT NULL")
    private String description;

    @Pattern(regexp = "^(Tablet|Capsule|Liquid|Injection)$", message = "Form must be one of Tablet, Capsule, Liquid, Injection")
    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String form;
}
