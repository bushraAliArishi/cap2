package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.ListOfUserAndMedicines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListOfUserAndMedicinesRepository extends JpaRepository<ListOfUserAndMedicines, Integer> {
    List<ListOfUserAndMedicines> findByUserId(Integer userId);
    List<ListOfUserAndMedicines> findByMedicineId(Integer medicineId);

    @Query("SELECT l FROM ListOfUserAndMedicines l WHERE l.userId = ?1 AND l.medicineId = ?2")
    ListOfUserAndMedicines findByUserAndMedicine(Integer userId, Integer medicineId);
}
