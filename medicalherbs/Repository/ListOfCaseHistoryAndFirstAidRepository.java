package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.ListOfCaseHistoryAndFirstAid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListOfCaseHistoryAndFirstAidRepository extends JpaRepository<ListOfCaseHistoryAndFirstAid, Integer> {
    ListOfCaseHistoryAndFirstAid findListOfCaseHistoryAndFirstAidByCaseHistoryId (Integer caseId);
    ListOfCaseHistoryAndFirstAid findListOfCaseHistoryAndFirstAidByFirstAidId (Integer firstAidId);
}
