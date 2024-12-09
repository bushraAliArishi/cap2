package com.example.medicalherbs.Service;

import com.example.medicalherbs.ApiResponse.ApiException;
import com.example.medicalherbs.Model.DiseaseInteraction;
import com.example.medicalherbs.Repository.DiseaseInteractionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiseaseInteractionService {
    private final DiseaseInteractionRepository diseaseInteractionRepository;

    public DiseaseInteraction getDiseaseInteractionById(Integer id) {
        DiseaseInteraction interaction = diseaseInteractionRepository.findDiseaseInteractionById(id);
        if (interaction == null) {
            throw new ApiException("Disease interaction not found");
        }
        return interaction;
    }

    public DiseaseInteraction getDiseaseInteractionByDiseaseName(String diseaseName) {
        DiseaseInteraction interaction = diseaseInteractionRepository.findDiseaseInteractionByDiseaseName(diseaseName);
        if (interaction == null) {
            throw new ApiException("Disease interaction not found");
        }
        return interaction;
    }

    public List<DiseaseInteraction> searchDiseaseInteractionsByDetails(String keyword) {
        List<DiseaseInteraction> interactions = diseaseInteractionRepository.searchDiseaseInteractionByDetails(keyword);
        if (interactions.isEmpty()) {
            throw new ApiException("No disease interactions found matching the provided keyword");
        }
        return interactions;
    }

    public void addDiseaseInteraction(DiseaseInteraction diseaseInteraction) {
        if (diseaseInteraction.getDiseaseName().isEmpty() || diseaseInteraction.getInteractionDetails().isEmpty()) {
            throw new ApiException("Disease name and details cannot be empty");
        }
        diseaseInteractionRepository.save(diseaseInteraction);
    }

    public void updateDiseaseInteraction(Integer id, DiseaseInteraction diseaseInteraction) {
        DiseaseInteraction existing = diseaseInteractionRepository.findDiseaseInteractionById(id);
        if (existing != null) {
            existing.setDiseaseName(diseaseInteraction.getDiseaseName());
            existing.setInteractionDetails(diseaseInteraction.getInteractionDetails());
            diseaseInteractionRepository.save(existing);
        } else {
            throw new ApiException("Disease interaction not found");
        }
    }

    public void deleteDiseaseInteraction(Integer id) {
        DiseaseInteraction existing = diseaseInteractionRepository.findDiseaseInteractionById(id);
        if (existing != null) {
            diseaseInteractionRepository.delete(existing);
        } else {
            throw new ApiException("Disease interaction not found");
        }
    }
}
