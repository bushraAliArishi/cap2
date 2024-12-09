package com.example.medicalherbs.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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

    @NotEmpty(message = "Herb ID must not be empty")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer herbId;

    @NotEmpty(message = "Conflicting entity ID must not be empty")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer conflictingEntityId;

    @Pattern(regexp = "^(Herb|Drug|Disease)$", message = "Conflicting type must be Herb, Drug, or Disease")
    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String conflictingType;

    @NotEmpty(message = "Details must not be empty")
    @Column(columnDefinition = "TEXT NOT NULL")
    private String details;
}
