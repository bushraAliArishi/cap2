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
public class DoctorInstruction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Doctor ID must not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer doctorId;

    @NotNull(message = "User ID must not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer userId;

    @NotNull(message = "Case History ID must not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer caseHistoryId;

    @NotEmpty(message = "Instruction details must not be empty")
    @Column(columnDefinition = "TEXT NOT NULL")
    private String instructionDetails;
}
