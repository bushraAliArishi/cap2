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
public class ListOfUserAndDiseases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "User ID must not be empty")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer userId;

    @NotEmpty(message = "Disease ID must not be empty")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer diseaseId;
}
