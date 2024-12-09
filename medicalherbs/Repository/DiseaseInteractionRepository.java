package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.DiseaseInteraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiseaseInteractionRepository extends JpaRepository<DiseaseInteraction, Integer> {
    DiseaseInteraction findDiseaseInteractionById(Integer id);

    DiseaseInteraction findDiseaseInteractionByDiseaseName(String diseaseName);

    @Query("SELECT d FROM DiseaseInteraction d WHERE d.interactionDetails LIKE %?1%")
    List<DiseaseInteraction> searchDiseaseInteractionByDetails(String keyword);
}
