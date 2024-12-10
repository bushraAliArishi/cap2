package com.example.medicalherbs.Service;

import com.example.medicalherbs.Model.Disease;
import com.example.medicalherbs.Model.ListOfUserAndDiseases;
import com.example.medicalherbs.Repository.ListOfUserAndDiseasesRepository;
import com.example.medicalherbs.ApiResponse.ApiException;
import com.example.medicalherbs.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListOfUserAndDiseasesService {
    private final ListOfUserAndDiseasesRepository repository;
    private final PatientRepository patientRepository;
    public List<Disease> getDiseasesByUserId(Integer userId) {
        if (!patientRepository.existsById(userId)) {
            throw new RuntimeException("User not found");
        }
        return repository.findDiseasesByUserId(userId);
    }

    public List<ListOfUserAndDiseases> getLinksByUserId(Integer userId) {
        return repository.findByUserId(userId);
    }

    public List<ListOfUserAndDiseases> getLinksByDiseaseId(Integer diseaseId) {
        return repository.findByDiseaseId(diseaseId);
    }

    public void addLink(ListOfUserAndDiseases link) {
        repository.save(link);
    }

    public void deleteLink(Integer id) {
        ListOfUserAndDiseases existing = repository.findById(id).orElse(null);
        if (existing == null) {
            throw new ApiException("Link not found");
        }
        repository.delete(existing);
    }
}
