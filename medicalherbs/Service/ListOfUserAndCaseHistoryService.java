package com.example.medicalherbs.Service;

import com.example.medicalherbs.Model.ListOfUserAndCaseHistory;
import com.example.medicalherbs.Repository.CaseHistoryRepository;
import com.example.medicalherbs.Repository.ListOfUserAndCaseHistoryRepository;
import com.example.medicalherbs.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListOfUserAndCaseHistoryService {

    private final ListOfUserAndCaseHistoryRepository listOfUserAndCaseHistoryRepository;
    private final UserRepository userRepository;
    private final CaseHistoryRepository caseHistoryRepository;

    public void addUserCaseHistory(Integer userId, Integer caseHistoryId) {
        if (userRepository.findUserById(userId) == null) {
            throw new RuntimeException("User not found");
        }
        if (caseHistoryRepository.findCaseHistoryById(caseHistoryId) == null) {
            throw new RuntimeException("Case history not found");
        }
        ListOfUserAndCaseHistory link = new ListOfUserAndCaseHistory();
        link.setUserId(userId);
        link.setCaseHistoryId(caseHistoryId);
        listOfUserAndCaseHistoryRepository.save(link);
    }

    public List<ListOfUserAndCaseHistory> getCaseHistoriesByUserId(Integer userId) {
        return listOfUserAndCaseHistoryRepository.findByUserId(userId);
    }

    public List<ListOfUserAndCaseHistory> getUsersByCaseHistoryId(Integer caseHistoryId) {
        return listOfUserAndCaseHistoryRepository.findByCaseHistoryId(caseHistoryId);
    }
}
