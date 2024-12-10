package com.example.medicalherbs.Service;

import com.example.medicalherbs.Model.Stent;
import com.example.medicalherbs.Repository.PatientRepository;
import com.example.medicalherbs.Repository.StentRepository;
import com.example.medicalherbs.ApiResponse.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StentService {
    private final StentRepository stentRepository;
    private final PatientRepository patientRepository;

    public Stent getStentById(Integer id) {
        Stent stent = stentRepository.findStentById(id);
        if (stent == null) {
            throw new ApiException("Stent not found");
        }
        return stent;
    }

    public void addStent(Stent stent) {
        // Check if the user exists
        if (stent.getUserId() != null && patientRepository.findById(stent.getUserId()).isEmpty()) {
            throw new ApiException("User not found for the provided User ID");
        }

        stentRepository.save(stent);
    }

    public void updateStent(Integer id, Stent stent) {
        Stent existing = stentRepository.findStentById(id);
        if (existing == null) {
            throw new ApiException("Stent not found");
        }

        // Check if the user exists
        if (stent.getUserId() != null && patientRepository.findById(stent.getUserId()).isEmpty()) {
            throw new ApiException("User not found for the provided User ID");
        }

        existing.setType(stent.getType());
        existing.setLocation(stent.getLocation());
        existing.setUserId(stent.getUserId());
        existing.setDetails(stent.getDetails());
        existing.setStatus(stent.getStatus());
        stentRepository.save(existing);
    }

    public void deleteStent(Integer id) {
        Stent existing = stentRepository.findStentById(id);
        if (existing == null) {
            throw new ApiException("Stent not found");
        }
        stentRepository.delete(existing);
    }
}
