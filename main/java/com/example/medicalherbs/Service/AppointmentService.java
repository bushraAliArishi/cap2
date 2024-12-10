package com.example.medicalherbs.Service;

import com.example.medicalherbs.Model.Appointment;
import com.example.medicalherbs.Repository.AppointmentRepository;
import com.example.medicalherbs.Repository.DoctorRepository;
import com.example.medicalherbs.Repository.PatientRepository;
import com.example.medicalherbs.ApiResponse.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public Appointment getAppointmentById(Integer id) {
        Appointment appointment = appointmentRepository.findAppointmentById(id);
        if (appointment == null) {
            throw new ApiException("Appointment not found");
        }
        return appointment;
    }

    public List<Appointment> getAppointmentsByDoctorId(Integer doctorId) {
        if (doctorRepository.findById(doctorId).isEmpty()) {
            throw new ApiException("Doctor not found");
        }
        return appointmentRepository.findAppointmentsByDoctorId(doctorId);
    }
    public List<Appointment> getAllAppointments() {

        return appointmentRepository.findAll();
    }

    public List<Appointment> getAppointmentsByPatientId(Integer patientId) {
        if (patientRepository.findPatientById(patientId)!=null) {
            throw new ApiException("Patient not found");
        }
        return appointmentRepository.findAppointmentsByDoctorId(patientId);
    }


    public Appointment getAppointmentsByPatientIdAndDateAndTimeAndStatus(Integer patientId, LocalDate date , LocalTime time,String status) {
        if (patientRepository.findPatientById(patientId)==null) {
            throw new ApiException("Patient not found");
        }
        return appointmentRepository.findAppointmentByPatientIdAndDateAndTimeAndStatus(patientId,date,time,status);
    }


    public Appointment getAppointmentsByDoctorIdAndDateAndTimeAndStatus(Integer doctorId, LocalDate date , LocalTime time,String status) {
        if (doctorRepository.findDoctorById(doctorId)==null) {
            throw new ApiException("Doctor not found");
        }
        return appointmentRepository.findAppointmentByDoctorIdAndDateAndTimeAndStatus(doctorId,date,time,status);
    }


    public void addAppointment(Appointment appointment) {
        if (doctorRepository.findById(appointment.getDoctorId()).isEmpty()) {
            throw new ApiException("Doctor not found");
        }
        if (patientRepository.findById(appointment.getPatientId()).isEmpty()) {
            throw new ApiException("User not found");
        }
        if (appointmentRepository.findAppointmentByDoctorIdAndDateAndTime(appointment.getDoctorId(),appointment.getDate(),appointment.getTime())!=null ){
            throw new ApiException("there is appointment in the same time ");
        }
        if (!"Pending".equals(appointment.getStatus())) {
            throw new ApiException("Only 'Pending' status is allowed during creation");
        }
        appointmentRepository.save(appointment);
    }

    public void updateAppointment(Integer id, Appointment appointment) {
        Appointment existing = appointmentRepository.findAppointmentById(id);
        if (existing == null) {
            throw new ApiException("Appointment not found");
        }
        if (doctorRepository.findById(appointment.getDoctorId()).isEmpty()) {
            throw new ApiException("Doctor not found");
        }
        if (patientRepository.findById(appointment.getPatientId()).isEmpty()) {
            throw new ApiException("User not found");
        }

        existing.setDoctorId(appointment.getDoctorId());
        existing.setPatientId(appointment.getPatientId());
        existing.setDate(appointment.getDate());
        existing.setTime(appointment.getTime());
        existing.setStatus(appointment.getStatus());
        appointmentRepository.save(existing);
    }
    public void rejectListOfAppointmentForPatient(Integer patient,LocalDate date,LocalTime time){
        for (Appointment a:appointmentRepository.findAppointmentsByPatientIdAndDateAndTimeAndStatus(patient,date,time,"Pending")) {
            a.setStatus("Rejected");
            appointmentRepository.save(a);
        }

    }
    public void rejectAppointmentForDoctorAtSameTimeAsCurrent(Appointment appointment){
        for (Appointment a : appointmentRepository.findAppointmentsByDoctorIdAndDateAndTimeAndStatus(appointment.getDoctorId(),
                appointment.getDate(),appointment.getTime(),"Pending")){
            a.setStatus("Rejected");
            appointmentRepository.save(a);
        }

    }

    public void deleteAppointment(Integer id) {
        Appointment existing = appointmentRepository.findAppointmentById(id);
        if (existing == null) {
            throw new ApiException("Appointment not found");
        }
        appointmentRepository.delete(existing);
    }
}
