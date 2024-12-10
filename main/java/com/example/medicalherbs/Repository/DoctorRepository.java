package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Doctor findDoctorById(Integer id);
    List<Doctor> findDoctorsBySpecialization(String specialization);

    List<Doctor> findDoctorsByHospitalId(Integer hospitalId);
}
