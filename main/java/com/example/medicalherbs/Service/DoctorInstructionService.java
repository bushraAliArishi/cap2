package com.example.medicalherbs.Service;

import com.example.medicalherbs.Model.DoctorInstruction;
import com.example.medicalherbs.Repository.DoctorInstructionRepository;
import com.example.medicalherbs.Repository.CaseHistoryRepository;
import com.example.medicalherbs.Repository.DoctorRepository;
import com.example.medicalherbs.ApiResponse.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorInstructionService {
    private final DoctorInstructionRepository doctorInstructionRepository;
    private final DoctorRepository doctorRepository;
    private final CaseHistoryRepository caseHistoryRepository;

    public DoctorInstruction getInstructionById(Integer id) {
        DoctorInstruction instruction = doctorInstructionRepository.findById(id).orElse(null);
        if (instruction == null) {
            throw new ApiException("Doctor instruction not found");
        }
        return instruction;
    }

    public List<DoctorInstruction> getInstructionsByDoctorId(Integer doctorId) {
        if (doctorRepository.findById(doctorId).isEmpty()) {
            throw new ApiException("Doctor not found");
        }
        return doctorInstructionRepository.findByDoctorId(doctorId);
    }
 public List<DoctorInstruction> getAllInstructions() {

        return doctorInstructionRepository.findAll();
    }

    public List<DoctorInstruction> getInstructionsByCaseHistoryId(Integer caseHistoryId) {
        if (caseHistoryRepository.findById(caseHistoryId).isEmpty()) {
            throw new ApiException("Case history not found");
        }
        return doctorInstructionRepository.findByCaseHistoryId(caseHistoryId);
    }

    public void addInstruction(DoctorInstruction instruction) {
        if (doctorRepository.findById(instruction.getDoctorId()).isEmpty()) {
            throw new ApiException("Doctor not found");
        }
        if (caseHistoryRepository.findById(instruction.getCaseHistoryId()).isEmpty()) {
            throw new ApiException("Case history not found");
        }
        doctorInstructionRepository.save(instruction);
    }

    public void updateInstruction(Integer id, DoctorInstruction instruction) {
        DoctorInstruction existing = doctorInstructionRepository.findById(id).orElse(null);
        if (existing == null) {
            throw new ApiException("Doctor instruction not found");
        }
        if (doctorRepository.findById(instruction.getDoctorId()).isEmpty()) {
            throw new ApiException("Doctor not found");
        }
        if (caseHistoryRepository.findById(instruction.getCaseHistoryId()).isEmpty()) {
            throw new ApiException("Case history not found");
        }

        existing.setDoctorId(instruction.getDoctorId());
        existing.setCaseHistoryId(instruction.getCaseHistoryId());
        doctorInstructionRepository.save(existing);
    }

    public void deleteInstruction(Integer id) {
        if (doctorInstructionRepository.findById(id).isEmpty()) {
            throw new ApiException("Doctor instruction not found");
        }
        doctorInstructionRepository.deleteById(id);
    }
}
