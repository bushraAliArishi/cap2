package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.Disease;
import com.example.medicalherbs.Model.ListOfUserAndDiseases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListOfUserAndDiseasesRepository extends JpaRepository<ListOfUserAndDiseases, Integer> {
    List<ListOfUserAndDiseases> findByUserId(Integer patientId);
    @Query("SELECT d FROM Disease d JOIN ListOfUserAndDiseases lud ON d.id = lud.diseaseId WHERE lud.userId = ?1")
    List<Disease> findDiseasesByUserId(Integer patientId);

    List<ListOfUserAndDiseases> findByDiseaseId(Integer diseaseId);
}
