package com.example.medicalherbs.Service;

import com.example.medicalherbs.ApiResponse.ApiException;
import com.example.medicalherbs.Model.Stint;
import com.example.medicalherbs.Repository.StintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StintService {
    private final StintRepository stintRepository;

    public Stint getStintById(Integer id) {
        Stint stint = stintRepository.findStintById(id);
        if (stint == null) {
            throw new ApiException("Stint not found");
        }
        return stint;
    }

    public List<Stint> getStintsByStatus(String status) {
        List<Stint> stints = stintRepository.findStintByStatus(status);
        if (stints.isEmpty()) {
            throw new ApiException("No stints found with the given status");
        }
        return stints;
    }

    public List<Stint> getStintsByTypeAndLocation(String type, String location) {
        List<Stint> stints = stintRepository.findStintByTypeAndLocation(type, location);
        if (stints.isEmpty()) {
            throw new ApiException("No stints found with the given type and location");
        }
        return stints;
    }

    public void addStint(Stint stint) {
        stintRepository.save(stint);
    }

    public void updateStint(Integer id, Stint stint) {
        Stint existing = stintRepository.findStintById(id);
        if (existing == null) {
            throw new ApiException("Stint not found");
        }
        existing.setType(stint.getType());
        existing.setStatus(stint.getStatus());
        existing.setLocation(stint.getLocation());
        stintRepository.save(existing);
    }

    public void deleteStint(Integer id) {
        Stint existing = stintRepository.findStintById(id);
        if (existing == null) {
            throw new ApiException("Stint not found");
        }
        stintRepository.delete(existing);
    }
}
