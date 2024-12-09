package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.FirstAid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FirstAidRepository extends JpaRepository<FirstAid, Integer> {
    FirstAid findFirstAidById(Integer id);

    List<FirstAid> findFirstAidByMedicalCondition(String mCondition);

    @Query("SELECT f FROM FirstAid f WHERE f.steps LIKE %?1%")
    List<FirstAid> searchFirstAidBySteps(String keyword);
}
