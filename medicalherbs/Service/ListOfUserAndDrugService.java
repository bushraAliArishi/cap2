package com.example.medicalherbs.Service;

import com.example.medicalherbs.Model.ListOfUserAndMedicines;
import com.example.medicalherbs.Repository.ListOfUserAndMedicinesRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListOfUserAndDrugService {
    private final ListOfUserAndMedicinesRepository listOfUserAndDrugRepository;

    public List<ListOfUserAndMedicines> getAllByUserId(Integer userId) {
        return listOfUserAndDrugRepository.findByUserId(userId);
    }

    public List<ListOfUserAndMedicines> getAllByDrugId(Integer drugId) {
        return listOfUserAndDrugRepository.findByMedicineId(drugId);
    }

    public void addListOfUserAndDrug(@Valid ListOfUserAndMedicines link) {
        listOfUserAndDrugRepository.save(link);
    }

    public void updateListOfUserAndDrug(Integer id, @Valid ListOfUserAndMedicines link) {
        ListOfUserAndMedicines existingLink = listOfUserAndDrugRepository.findById(id).orElse(null);
        if (existingLink != null) {
            existingLink.setUserId(link.getUserId());
            existingLink.setMedicineId(link.getMedicineId());
            listOfUserAndDrugRepository.save(existingLink);
        } else {
            throw new RuntimeException("Link not found");
        }
    }

    public void deleteListOfUserAndDrug(Integer id) {
        ListOfUserAndMedicines existingLink = listOfUserAndDrugRepository.findById(id).orElse(null);
        if (existingLink != null) {
            listOfUserAndDrugRepository.delete(existingLink);
        } else {
            throw new RuntimeException("Link not found");
        }
    }
}
