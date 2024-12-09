package com.example.medicalherbs.Service;

import com.example.medicalherbs.ApiResponse.ApiException;
import com.example.medicalherbs.Model.FirstAid;
import com.example.medicalherbs.Repository.FirstAidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FirstAidService {
    private final FirstAidRepository firstAidRepository;

    public FirstAid getFirstAidById(Integer id) {
        FirstAid firstAid = firstAidRepository.findFirstAidById(id);
        if (firstAid == null) {
            throw new ApiException("First aid record not found");
        }
        return firstAid;
    }

    public List<FirstAid> getFirstAidByCondition(String mCondition) {
        List<FirstAid> firstAidList = firstAidRepository.findFirstAidByMedicalCondition(mCondition);
        if (firstAidList.isEmpty()) {
            throw new ApiException("No first aid records found for the specified condition");
        }
        return firstAidList;
    }

    public List<FirstAid> searchFirstAidBySteps(String keyword) {
        List<FirstAid> firstAidList = firstAidRepository.searchFirstAidBySteps(keyword);
        if (firstAidList.isEmpty()) {
            throw new ApiException("No first aid records found matching the keyword");
        }
        return firstAidList;
    }

    public void addFirstAid(FirstAid firstAid) {
        if (firstAid.getMedicalCondition().isEmpty() || firstAid.getSteps().isEmpty()) {
            throw new ApiException("Condition and steps cannot be empty");
        }
        firstAidRepository.save(firstAid);
    }

    public void updateFirstAid(Integer id, FirstAid firstAid) {
        FirstAid existing = firstAidRepository.findFirstAidById(id);
        if (existing != null) {
            existing.setMedicalCondition(firstAid.getMedicalCondition());
            existing.setSteps(firstAid.getSteps());
            firstAidRepository.save(existing);
        } else {
            throw new ApiException("First aid record not found");
        }
    }

    public void deleteFirstAid(Integer id) {
        FirstAid existing = firstAidRepository.findFirstAidById(id);
        if (existing != null) {
            firstAidRepository.delete(existing);
        } else {
            throw new ApiException("First aid record not found");
        }
    }
}
