package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    Appointment findAppointmentById(Integer id);

    List<Appointment> findAppointmentsByDoctorId(Integer doctorId);

    List<Appointment> findAppointmentsByUserId(Integer userId);

    @Query("SELECT a FROM Appointment a WHERE a.doctorId = ?1 AND a.date = ?2")
    List<Appointment> findAppointmentsByDoctorIdAndDate(Integer doctorId, LocalDateTime date);

}
