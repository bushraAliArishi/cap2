package com.example.medicalherbs.Service;

import com.example.medicalherbs.ApiResponse.ApiException;
import com.example.medicalherbs.Model.CaseHistory;
import com.example.medicalherbs.Repository.CaseHistoryRepository;
import com.example.medicalherbs.Repository.HerbRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CaseHistoryService {
    private final CaseHistoryRepository caseHistoryRepository;
    private final HerbRepository herbRepository;

    // Retrieve CaseHistory by ID
    public CaseHistory getCaseHistoryById(Integer id) {
        CaseHistory caseHistory = caseHistoryRepository.findCaseHistoryById(id);
        if (caseHistory == null) {
            throw new ApiException("Case history not found");
        }
        return caseHistory;
    }

    // Retrieve CaseHistories by Conflicting Type
    public List<CaseHistory> getCaseHistoriesByConflictingType(String conflictingType) {
        List<CaseHistory> caseHistories = caseHistoryRepository.findCaseHistoriesByConflictingType(conflictingType);
        if (caseHistories.isEmpty()) {
            throw new ApiException("No case histories found for the specified conflicting type");
        }
        return caseHistories;
    }

    // Add a new CaseHistory
    public void addCaseHistory(CaseHistory caseHistory) {
        if (!herbRepository.existsById(caseHistory.getHerbId())) {
            throw new ApiException("Herb not found");
        }
        caseHistoryRepository.save(caseHistory);
    }

    // Update an existing CaseHistory
    public void updateCaseHistory(Integer id, CaseHistory caseHistory) {
        CaseHistory existing = caseHistoryRepository.findCaseHistoryById(id);
        if (existing == null) {
            throw new ApiException("Case history not found");
        }
        if (!herbRepository.existsById(caseHistory.getHerbId())) {
            throw new ApiException("Herb not found");
        }
        existing.setHerbId(caseHistory.getHerbId());
        existing.setConflictingEntityId(caseHistory.getConflictingEntityId());
        existing.setConflictingType(caseHistory.getConflictingType());
        existing.setDetails(caseHistory.getDetails());
        caseHistoryRepository.save(existing);
    }

    // Delete a CaseHistory
    public void deleteCaseHistory(Integer id) {
        CaseHistory existing = caseHistoryRepository.findCaseHistoryById(id);
        if (existing == null) {
            throw new ApiException("Case history not found");
        }
        caseHistoryRepository.delete(existing);
    }

    // Check if a herb conflict exists
    public String checkHerbConflict(Integer herbId, Integer conflictingEntityId, String conflictingType) {
        boolean conflictExists = caseHistoryRepository.existsByHerbIdAndConflictingEntityIdAndConflictingType(herbId, conflictingEntityId, conflictingType);
        return conflictExists ? "Conflict exists" : "No conflict";
    }

    // Retrieve conflicts by Herb ID
    public List<CaseHistory> getConflictsByHerbId(Integer herbId) {
        List<CaseHistory> conflicts = caseHistoryRepository.findCaseHistoriesByHerbId(herbId);
        if (conflicts.isEmpty()) {
            throw new ApiException("No conflicts found for the specified herb ID");
        }
        return conflicts;
    }

    // Retrieve conflicts by Type
    public List<CaseHistory> getConflictsByType(String type) {
        List<CaseHistory> conflicts = caseHistoryRepository.findCaseHistoriesByConflictingType(type);
        if (conflicts.isEmpty()) {
            throw new ApiException("No conflicts found for the specified type");
        }
        return conflicts;
    }
}
