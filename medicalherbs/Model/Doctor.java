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
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Doctor name must not be empty")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String name;

    @NotEmpty(message = "Specialization must not be empty")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String specialization;

    @NotEmpty(message = "Contact information must not be empty")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String contactInfo;
}
