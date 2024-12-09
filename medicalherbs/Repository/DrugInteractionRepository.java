package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.DrugInteraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugInteractionRepository extends JpaRepository<DrugInteraction, Integer> {
    DrugInteraction findDrugInteractionById(Integer id);

    DrugInteraction findDrugInteractionByDrugName(String drugName);

    @Query("SELECT d FROM DrugInteraction d WHERE d.interactionDetails LIKE %?1%")
    List<DrugInteraction> searchDrugInteractionByDetails(String keyword);
}
