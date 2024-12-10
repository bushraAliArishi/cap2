package com.example.medicalherbs.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "User ID must not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer userId;

    @NotNull(message = "Doctor ID must not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer doctorId;

    @NotNull(message = "Stent ID must not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer stentId;

    @NotEmpty(message = "Details must not be empty")
    @Column(columnDefinition = "TEXT NOT NULL")
    private String details;

    @NotNull(message = "DoctorInstruction ID must not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer instructionId;
}
