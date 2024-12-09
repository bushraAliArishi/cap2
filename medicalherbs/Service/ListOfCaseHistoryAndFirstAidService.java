package com.example.medicalherbs.Service;

import com.example.medicalherbs.ApiResponse.ApiException;
import com.example.medicalherbs.Model.ListOfCaseHistoryAndFirstAid;
import com.example.medicalherbs.Repository.CaseHistoryRepository;
import com.example.medicalherbs.Repository.FirstAidRepository;
import com.example.medicalherbs.Repository.ListOfCaseHistoryAndFirstAidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListOfCaseHistoryAndFirstAidService {
    private final ListOfCaseHistoryAndFirstAidRepository listOfCaseHistoryAndFirstAidRepository;
    private final CaseHistoryRepository caseHistoryRepository;
    private final FirstAidRepository firstAidRepository;

    public ListOfCaseHistoryAndFirstAid getById(Integer id) {
        ListOfCaseHistoryAndFirstAid record = listOfCaseHistoryAndFirstAidRepository.findById(id).orElse(null);
        if (record == null) {
            throw new ApiException("Record not found");
        }
        return record;
    }

    public List<ListOfCaseHistoryAndFirstAid> getAll() {
        return listOfCaseHistoryAndFirstAidRepository.findAll();
    }

    public void addRecord(ListOfCaseHistoryAndFirstAid record) {
        if (caseHistoryRepository.findCaseHistoryById(record.getCaseHistoryId()) == null) {
            throw new ApiException("Case history not found");
        }
        if (firstAidRepository.findById(record.getFirstAidId()).isEmpty()) {
            throw new ApiException("First aid record not found");
        }
        listOfCaseHistoryAndFirstAidRepository.save(record);
    }

    public void updateRecord(Integer id, ListOfCaseHistoryAndFirstAid updatedRecord) {
        ListOfCaseHistoryAndFirstAid existingRecord = listOfCaseHistoryAndFirstAidRepository.findById(id).orElse(null);
        if (existingRecord == null) {
            throw new ApiException("Record not found");
        }
        if (caseHistoryRepository.findCaseHistoryById(updatedRecord.getCaseHistoryId()) == null) {
            throw new ApiException("Case history not found");
        }
        if (firstAidRepository.findById(updatedRecord.getFirstAidId()).isEmpty()) {
            throw new ApiException("First aid record not found");
        }
        existingRecord.setCaseHistoryId(updatedRecord.getCaseHistoryId());
        existingRecord.setFirstAidId(updatedRecord.getFirstAidId());
        listOfCaseHistoryAndFirstAidRepository.save(existingRecord);
    }

    public void deleteRecord(Integer id) {
        ListOfCaseHistoryAndFirstAid record = listOfCaseHistoryAndFirstAidRepository.findById(id).orElse(null);
        if (record == null) {
            throw new ApiException("Record not found");
        }
        listOfCaseHistoryAndFirstAidRepository.delete(record);
    }
}
