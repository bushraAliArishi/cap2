package com.example.medicalherbs.Service;

import com.example.medicalherbs.Model.Herb;
import com.example.medicalherbs.Repository.HerbRepository;
import com.example.medicalherbs.ApiResponse.ApiException;
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

    public List<Herb> getHerbsByOptimalSeason(String season) {
        return herbRepository.findHerbsByOptimalSeason(season);
    }
    public List<Herb> getAllHerbs() {
        return herbRepository.findAll();
    }

    public void addHerb(Herb herb) {
        herbRepository.save(herb);
    }

    public void updateHerb(Integer id, Herb herb) {
        Herb existing = herbRepository.findHerbById(id);
        if (existing == null) {
            throw new ApiException("Herb not found");
        }
        existing.setName(herb.getName());
        existing.setDescription(herb.getDescription());
        existing.setOptimalSeason(herb.getOptimalSeason());
        herbRepository.save(existing);
    }

    public void deleteHerb(Integer id) {
        Herb existing = herbRepository.findHerbById(id);
        if (existing == null) {
            throw new ApiException("Herb not found");
        }
        herbRepository.delete(existing);
    }
}
