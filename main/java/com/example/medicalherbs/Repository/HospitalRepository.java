package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    Hospital findHospitalById(Integer id);
    List<Hospital> findHospitalsByLocation(String location);
    List<Hospital> findAll();
}
