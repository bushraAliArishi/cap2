package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.ListOfUserAndCaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListOfUserAndCaseHistoryRepository extends JpaRepository<ListOfUserAndCaseHistory, Integer> {
    List<ListOfUserAndCaseHistory> findByUserId(Integer userId);
    List<ListOfUserAndCaseHistory> findByCaseHistoryId(Integer caseHistoryId);

    @Query("SELECT l FROM ListOfUserAndCaseHistory l WHERE l.userId = ?1 AND l.caseHistoryId = ?2")
    ListOfUserAndCaseHistory findByUserAndCaseHistory(Integer userId, Integer caseHistoryId);
}
