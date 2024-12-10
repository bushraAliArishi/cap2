package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Patient findPatientById(Integer id);
    Patient findPatientByEmail(String email);
}
