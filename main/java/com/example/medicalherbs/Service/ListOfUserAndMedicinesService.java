package com.example.medicalherbs.Service;

import com.example.medicalherbs.Model.ListOfUserAndMedicines;
import com.example.medicalherbs.Model.Medicine;
import com.example.medicalherbs.Repository.ListOfUserAndMedicinesRepository;
import com.example.medicalherbs.ApiResponse.ApiException;
import com.example.medicalherbs.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListOfUserAndMedicinesService {
    private final ListOfUserAndMedicinesRepository repository;
    private final PatientRepository patientRepository;

    public List<Medicine> getMedicinesByUserId(Integer userId) {
        if (!patientRepository.existsById(userId)) {
            throw new RuntimeException("User not found");
        }
        return repository.findMedicinesByUserId(userId);
    }


    public List<ListOfUserAndMedicines> getLinksByUserId(Integer userId) {
        return repository.findByUserId(userId);
    }

    public List<ListOfUserAndMedicines> getLinksByMedicineId(Integer medicineId) {
        return repository.findByMedicineId(medicineId);
    }

    public void addLink(ListOfUserAndMedicines link) {
        repository.save(link);
    }

    public void deleteLink(Integer id) {
        ListOfUserAndMedicines existing = repository.findById(id).orElse(null);
        if (existing == null) {
            throw new ApiException("Link not found");
        }
        repository.delete(existing);
    }
}
