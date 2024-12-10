package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.DoctorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface DoctorAvailabilityRepository  extends JpaRepository<DoctorAvailability, Integer> {
    DoctorAvailability findDoctorAvailabilityById(Integer id);
    DoctorAvailability findDoctorAvailabilityByDoctorId(Integer id);
    DoctorAvailability findDoctorAvailabilityByDoctorIdAndStartTime(Integer id, LocalTime time);
    DoctorAvailability findDoctorAvailabilityByDoctorIdAndEndTime(Integer id, LocalTime time);

}
