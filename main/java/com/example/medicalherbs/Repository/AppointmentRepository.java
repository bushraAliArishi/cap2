package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    Appointment findAppointmentById(Integer id);
   List<Appointment> findAll();
    Appointment findAppointmentByDoctorIdAndDateAndTime(Integer id, LocalDate date,  LocalTime time);
     Appointment findAppointmentByPatientIdAndDateAndTimeAndStatus(Integer id, LocalDate date,  LocalTime time,String status);
     Appointment findAppointmentByDoctorIdAndDateAndTimeAndStatus(Integer id, LocalDate date,  LocalTime time,String status);
     List<Appointment> findAppointmentsByDoctorIdAndDateAndTimeAndStatus(Integer id, LocalDate date,  LocalTime time,String status);
    List<Appointment> findAppointmentsByPatientIdAndDateAndTimeAndStatus(Integer id, LocalDate date,  LocalTime time,String status);
    List<Appointment> findAppointmentsByDoctorId(Integer doctorId);

    List<Appointment> findAppointmentsByPatientId(Integer userId);
}
