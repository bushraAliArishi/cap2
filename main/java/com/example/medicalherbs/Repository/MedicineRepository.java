package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
    Medicine findMedicineById(Integer id);
    List<Medicine> findByNameContaining(String name);
}
