package com.example.medicalherbs.Service;

import com.example.medicalherbs.Model.Disease;
import com.example.medicalherbs.Repository.DiseaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiseaseService {
    private final DiseaseRepository diseaseRepository;

    public Disease getDiseaseById(Integer id) {
        return diseaseRepository.findDiseaseById(id);
    }

    public List<Disease> getAllDiseases() {
        return diseaseRepository.findAll();
    }

    public void addDisease(Disease disease) {
        diseaseRepository.save(disease);
    }

    public void updateDisease(Integer id, Disease disease) {
        Disease existing = diseaseRepository.findDiseaseById(id);
        if (existing != null) {
            existing.setName(disease.getName());
            existing.setDescription(disease.getDescription());
            diseaseRepository.save(existing);
        } else {
            throw new RuntimeException("Disease not found");
        }
    }

    public void deleteDisease(Integer id) {
        Disease existing = diseaseRepository.findDiseaseById(id);
        if (existing != null) {
            diseaseRepository.delete(existing);
        } else {
            throw new RuntimeException("Disease not found");
        }
    }
}
