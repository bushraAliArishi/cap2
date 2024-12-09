package com.example.medicalherbs.Service;

import com.example.medicalherbs.ApiResponse.ApiException;
import com.example.medicalherbs.Model.DrugInteraction;
import com.example.medicalherbs.Repository.DrugInteractionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrugInteractionService {
    private final DrugInteractionRepository drugInteractionRepository;

    public DrugInteraction getDrugInteractionById(Integer id) {
        DrugInteraction interaction = drugInteractionRepository.findDrugInteractionById(id);
        if (interaction == null) {
            throw new ApiException("Drug interaction not found");
        }
        return interaction;
    }

    public DrugInteraction getDrugInteractionByDrugName(String drugName) {
        DrugInteraction interaction = drugInteractionRepository.findDrugInteractionByDrugName(drugName);
        if (interaction == null) {
            throw new ApiException("Drug interaction not found");
        }
        return interaction;
    }

    public List<DrugInteraction> searchDrugInteractionsByDetails(String keyword) {
        return drugInteractionRepository.searchDrugInteractionByDetails(keyword);
    }

    public void addDrugInteraction(DrugInteraction drugInteraction) {
        drugInteractionRepository.save(drugInteraction);
    }

    public void updateDrugInteraction(Integer id, DrugInteraction drugInteraction) {
        DrugInteraction existing = drugInteractionRepository.findDrugInteractionById(id);
        if (existing != null) {
            existing.setDrugName(drugInteraction.getDrugName());
            existing.setInteractionDetails(drugInteraction.getInteractionDetails());
            drugInteractionRepository.save(existing);
        } else {
            throw new ApiException("Drug interaction not found");
        }
    }

    public void deleteDrugInteraction(Integer id) {
        DrugInteraction existing = drugInteractionRepository.findDrugInteractionById(id);
        if (existing != null) {
            drugInteractionRepository.delete(existing);
        } else {
            throw new ApiException("Drug interaction not found");
        }
    }
}
