package com.example.medicalherbs.Service;

import com.example.medicalherbs.ApiResponse.ApiException;
import com.example.medicalherbs.Model.Herb;
import com.example.medicalherbs.Repository.HerbRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HerbService {
    private final HerbRepository herbRepository;

    public Herb getHerbById(Integer id) {
        Herb herb = herbRepository.findHerbById(id);
        if (herb == null) {
            throw new ApiException("Herb not found");
        }
        return herb;
    }

    public Herb getHerbByName(String name) {
        Herb herb = herbRepository.findHerbByName(name);
        if (herb == null) {
            throw new ApiException("Herb not found");
        }
        return herb;
    }

    public List<Herb> getHerbsByOptimalSeason(String season) {
        List<Herb> herbs = herbRepository.findHerbByOptimalSeason(season);
        if (herbs.isEmpty()) {
            throw new ApiException("No herbs found for the specified season");
        }
        return herbs;
    }

    public void addHerb(Herb herb) {
        if (herb.getName().isEmpty() || herb.getOptimalSeason().isEmpty() ||  herb.getDescription().isEmpty()) {
            throw new ApiException("Herb details cannot be empty");
        }
        herbRepository.save(herb);
    }

    public void updateHerb(Integer id, Herb herb) {
        Herb existing = herbRepository.findHerbById(id);
        if (existing != null) {
            existing.setName(herb.getName());
            existing.setOptimalSeason(herb.getOptimalSeason());
            existing.setDescription(herb.getDescription());
            herbRepository.save(existing);
        } else {
            throw new ApiException("Herb not found");
        }
    }

    public void deleteHerb(Integer id) {
        Herb existing = herbRepository.findHerbById(id);
        if (existing != null) {
            herbRepository.delete(existing);
        } else {
            throw new ApiException("Herb not found");
        }
    }
}
