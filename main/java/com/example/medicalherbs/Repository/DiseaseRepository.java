package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Integer> {
    Disease findDiseaseById(Integer id);
    List<Disease> findByNameContaining(String name);
}



