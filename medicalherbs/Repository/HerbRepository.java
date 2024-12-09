package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.Herb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HerbRepository extends JpaRepository<Herb, Integer> {
    Herb findHerbById(Integer id);

    Herb findHerbByName(String name);

    @Query("SELECT h FROM Herb h WHERE h.optimalSeason = ?1")
    List<Herb> findHerbByOptimalSeason(String season);
}
