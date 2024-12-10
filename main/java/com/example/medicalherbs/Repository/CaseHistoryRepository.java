package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.CaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseHistoryRepository extends JpaRepository<CaseHistory, Integer> {
    CaseHistory findCaseHistoryById(Integer id);
    List<CaseHistory> findCaseHistoriesByDoctorId(Integer doctorId);
    List<CaseHistory> findCaseHistoriesByUserId(Integer userId);
}
