package com.example.medicalherbs.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotNull(message = "Hospital ID must not be null")
    private Integer hospitalId;
    @Column(name = "email", unique = true)
    @Email(message = "Email should be valid")
    private String email;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Phone number is invalid")
    private String phoneNumber;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    @Size(max = 100, message = "Workplace name cannot exceed 100 characters")
    private String workplace; // Clinic or hospital name

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    @Size(max = 255, message = "Workplace address cannot exceed 255 characters")
    private String workplaceAddress;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    @Min(value = 0, message = "Years of experience cannot be negative")
    private Integer yearsOfExperience;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    @Size(max = 1000, message = "Certifications description cannot exceed 1000 characters")
    private String certifications; // A detailed description of certifications

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    @Pattern(regexp = "^(Full-Time|Part-Time|On-Call)$", message = "Availability must be Full-Time, Part-Time, or On-Call")
    private String availability;

    @Column(columnDefinition = "double default 0.0")
    @Min(value = 0, message = "Consultation fee cannot be negative")
    private Double consultationFee=0.0;
}
