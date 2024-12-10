package com.example.medicalherbs.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int age;

    @NotEmpty(message = "Username must not be empty")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String username;

    @NotEmpty(message = "Password must not be empty")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String password;

    @Email(message = "Email must be valid")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String email;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    @NotEmpty(message = "Gender is required")
    @Pattern(regexp = "Male|Female", message = "Gender must be Male, Female")
    private String gender;

    @Column(columnDefinition = "Date NOT NULL")
    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Phone number is invalid")
    private String phoneNumber;

    @Column(columnDefinition = "VARCHAR(100) ")
    @Size(max = 255, message = "Address cannot exceed 255 characters")
    private String address;

    @Column(columnDefinition = "VARCHAR(3)")
    @Pattern(regexp = "^(A|B|AB|O)[+-]$", message = "Blood type must be A+, A-, B+, B-, AB+, AB-, O+, or O-")
    private String bloodType;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    @Size(max = 500, message = "Allergies description cannot exceed 500 characters")
    private String allergies;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    @Size(max = 500, message = "Current medications description cannot exceed 500 characters")
    private String currentMedications;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    @Size(max = 500, message = "Chronic conditions description cannot exceed 500 characters")
    private String chronicConditions;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    @Size(max = 100, message = "Emergency contact name cannot exceed 100 characters")
    private String emergencyContactName;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Emergency contact phone number is invalid")
    private String emergencyContactPhone;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    @Size(max = 100, message = "Insurance provider name cannot exceed 100 characters")
    private String insuranceProvider;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    @Size(max = 50, message = "Policy number cannot exceed 50 characters")
    private String policyNumber;

}
