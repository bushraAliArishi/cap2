package com.example.medicalherbs.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Disease name must not be empty")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String name;

    @NotEmpty(message = "Description must not be empty")
    @Column(columnDefinition = "TEXT NOT NULL")
    private String description;
}
