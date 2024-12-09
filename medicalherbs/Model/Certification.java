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
public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Certification name must not be empty")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String name;

    @NotEmpty(message = "Issuing organization must not be empty")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String issuingOrganization;

    @NotEmpty(message = "Date issued must not be empty")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String dateIssued;
}
