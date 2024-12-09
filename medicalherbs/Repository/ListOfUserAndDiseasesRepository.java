package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.ListOfUserAndDiseases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListOfUserAndDiseasesRepository extends JpaRepository<ListOfUserAndDiseases, Integer> {
    List<ListOfUserAndDiseases> findByUserId(Integer userId);
    List<ListOfUserAndDiseases> findByDiseaseId(Integer diseaseId);

    @Query("SELECT l FROM ListOfUserAndDiseases l WHERE l.userId = ?1 AND l.diseaseId = ?2")
    ListOfUserAndDiseases findByUserAndDisease(Integer userId, Integer diseaseId);
}
