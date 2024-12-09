package com.example.medicalherbs.Service;

import com.example.medicalherbs.Model.ListOfUserAndDiseases;
import com.example.medicalherbs.Repository.ListOfUserAndDiseasesRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListOfUserAndDiseaseService {
    private final ListOfUserAndDiseasesRepository listOfUserAndDiseaseRepository;

    public List<ListOfUserAndDiseases> getAllByUserId(Integer userId) {
        return listOfUserAndDiseaseRepository.findByUserId(userId);
    }

    public List<ListOfUserAndDiseases> getAllByDiseaseId(Integer diseaseId) {
        return listOfUserAndDiseaseRepository.findByDiseaseId(diseaseId);
    }

    public void addListOfUserAndDisease(@Valid ListOfUserAndDiseases link) {
        listOfUserAndDiseaseRepository.save(link);
    }

    public void updateListOfUserAndDisease(Integer id, @Valid ListOfUserAndDiseases link) {
        ListOfUserAndDiseases existingLink = listOfUserAndDiseaseRepository.findById(id).orElse(null);
        if (existingLink != null) {
            existingLink.setUserId(link.getUserId());
            existingLink.setDiseaseId(link.getDiseaseId());
            listOfUserAndDiseaseRepository.save(existingLink);
        } else {
            throw new RuntimeException("Link not found");
        }
    }

    public void deleteListOfUserAndDisease(Integer id) {
        ListOfUserAndDiseases existingLink = listOfUserAndDiseaseRepository.findById(id).orElse(null);
        if (existingLink != null) {
            listOfUserAndDiseaseRepository.delete(existingLink);
        } else {
            throw new RuntimeException("Link not found");
        }
    }
}
