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
public class FirstAid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Medical condition must not be empty")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String medicalCondition;

    @NotEmpty(message = "Steps must not be empty")
    @Column(columnDefinition = "TEXT NOT NULL")
    private String steps;
}