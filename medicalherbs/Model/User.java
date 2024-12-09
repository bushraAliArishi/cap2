package com.example.medicalherbs.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Username must not be empty")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String username;

    @NotEmpty(message = "Password must not be empty")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String password;

    @Email(message = "Email must be valid")
    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String email;

    @NotEmpty(message = "Role must not be empty")
    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String role;
}
