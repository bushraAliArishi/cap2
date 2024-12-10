package com.example.medicalherbs.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ListOfUserAndMedicines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "User ID must not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer userId;

    @NotNull(message = "Medicine ID must not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer medicineId;
}
