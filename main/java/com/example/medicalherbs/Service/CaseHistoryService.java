package com.example.medicalherbs.Service;

import com.example.medicalherbs.Model.CaseHistory;
import com.example.medicalherbs.Repository.*;
import com.example.medicalherbs.ApiResponse.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CaseHistoryService {
    private final CaseHistoryRepository caseHistoryRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final StentRepository stentRepository;
    private final DoctorInstructionRepository doctorInstructionRepository;

    public CaseHistory getCaseHistoryById(Integer id) {
        CaseHistory caseHistory = caseHistoryRepository.findCaseHistoryById(id);
        if (caseHistory == null) {
            throw new ApiException("Case history not found");
        }
        return caseHistory;
    }

    public List<CaseHistory> getCaseHistoriesByDoctorId(Integer doctorId) {
        if (doctorRepository.findById(doctorId).isEmpty()) {
            throw new ApiException("Doctor not found");
        }
        return caseHistoryRepository.findCaseHistoriesByDoctorId(doctorId);
    }

    public List<CaseHistory> getCaseHistoriesByUserId(Integer patientId) {
        if (patientRepository.findById(patientId).isEmpty()) {
            throw new ApiException("patient not found");
        }
        return caseHistoryRepository.findCaseHistoriesByUserId(patientId);
    }

    public void addCaseHistory(CaseHistory caseHistory) {
        if (patientRepository.findById(caseHistory.getUserId()).isEmpty()) {
            throw new ApiException("User not found");
        }
        if (doctorRepository.findById(caseHistory.getDoctorId()).isEmpty()) {
            throw new ApiException("Doctor not found");
        }
        if (stentRepository.findById(caseHistory.getStentId()).isEmpty()) {
            throw new ApiException("Stent not found");
        }
        if (doctorInstructionRepository.findById(caseHistory.getInstructionId()).isEmpty()) {
            throw new ApiException("Doctor Instruction not found");
        }
        caseHistoryRepository.save(caseHistory);
    }

    public void updateCaseHistory(Integer id, CaseHistory caseHistory) {
        CaseHistory existing = caseHistoryRepository.findCaseHistoryById(id);
        if (existing == null) {
            throw new ApiException("Case history not found");
        }
        if (patientRepository.findById(caseHistory.getUserId()).isEmpty()) {
            throw new ApiException("User not found");
        }
        if (doctorRepository.findById(caseHistory.getDoctorId()).isEmpty()) {
            throw new ApiException("Doctor not found");
        }
        if (stentRepository.findById(caseHistory.getStentId()).isEmpty()) {
            throw new ApiException("Stent not found");
        }
        if (doctorInstructionRepository.findById(caseHistory.getInstructionId()).isEmpty()) {
            throw new ApiException("Doctor Instruction not found");
        }

        existing.setUserId(caseHistory.getUserId());
        existing.setDoctorId(caseHistory.getDoctorId());
        existing.setStentId(caseHistory.getStentId());
        existing.setInstructionId(caseHistory.getInstructionId());
        existing.setDetails(caseHistory.getDetails());
        caseHistoryRepository.save(existing);
    }

    public void deleteCaseHistory(Integer id) {
        CaseHistory existing = caseHistoryRepository.findCaseHistoryById(id);
        if (existing == null) {
            throw new ApiException("Case history not found");
        }
        caseHistoryRepository.delete(existing);
    }
}
