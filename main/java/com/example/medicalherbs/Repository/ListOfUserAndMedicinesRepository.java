package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.ListOfUserAndMedicines;
import com.example.medicalherbs.Model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListOfUserAndMedicinesRepository extends JpaRepository<ListOfUserAndMedicines, Integer> {
    List<ListOfUserAndMedicines> findByUserId(Integer patientId);
    @Query("SELECT m FROM Medicine m JOIN ListOfUserAndMedicines lum ON m.id = lum.medicineId WHERE lum.userId = ?1")
    List<Medicine> findMedicinesByUserId(Integer patientId);

    List<ListOfUserAndMedicines> findByMedicineId(Integer medicineId);
}
