package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.Stent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StentRepository extends JpaRepository<Stent, Integer> {
    Stent findStentById(Integer id);
    List<Stent> findStentsByUserId(Integer userId);
    List<Stent> findStentsByStatus(String status);
}
