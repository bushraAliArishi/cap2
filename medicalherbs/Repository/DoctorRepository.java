package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Doctor findDoctorById(Integer id);

    Doctor findDoctorByName(String name);

    @Query("SELECT d FROM Doctor d WHERE d.specialization = ?1")
    List<Doctor> findDoctorBySpecialization(String specialization);
}
