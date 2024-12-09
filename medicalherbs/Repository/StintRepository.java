package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.Stint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface StintRepository extends JpaRepository<Stint, Integer> {
    Stint findStintById(Integer id);


    List<Stint> findStintByStatus(String status);

    List<Stint> findStintByTypeAndLocation(String type, String location);

}