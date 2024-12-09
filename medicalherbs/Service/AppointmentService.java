package com.example.medicalherbs.Service;

import com.example.medicalherbs.ApiResponse.ApiException;
import com.example.medicalherbs.Model.Appointment;
import com.example.medicalherbs.Repository.AppointmentRepository;
import com.example.medicalherbs.Repository.DoctorRepository;
import com.example.medicalherbs.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;

    public Appointment getAppointmentById(Integer id) {
        Appointment appointment = appointmentRepository.findAppointmentById(id);
        if (appointment == null) {
            throw new ApiException("Appointment not found");
        }
        return appointment;
    }

    public List<Appointment> getAppointmentsByDoctorId(Integer doctorId) {
        List<Appointment> appointments = appointmentRepository.findAppointmentsByDoctorId(doctorId);
        if (appointments.isEmpty()) {
            throw new ApiException("No appointments found for the doctor");
        }
        return appointments;
    }

    public List<Appointment> getAppointmentsByUserId(Integer userId) {
        List<Appointment> appointments = appointmentRepository.findAppointmentsByUserId(userId);
        if (appointments.isEmpty()) {
            throw new ApiException("No appointments found for the user");
        }
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        if (doctorRepository.findDoctorById(appointment.getDoctorId()) == null) {
            throw new ApiException("Doctor not found");
        }
        if (userRepository.findUserById(appointment.getUserId()) == null) {
            throw new ApiException("User not found");
        }
        appointmentRepository.save(appointment);
    }

    public void updateAppointment(Integer id, Appointment appointment) {
        Appointment existing = appointmentRepository.findAppointmentById(id);
        if (existing == null) {
            throw new ApiException("Appointment not found");
        }
        if (doctorRepository.findDoctorById(appointment.getDoctorId()) == null) {
            throw new ApiException("Doctor not found");
        }
        if (userRepository.findUserById(appointment.getUserId()) == null) {
            throw new ApiException("User not found");
        }
        existing.setDoctorId(appointment.getDoctorId());
        existing.setUserId(appointment.getUserId());
        existing.setType(appointment.getType());
        existing.setDate(appointment.getDate());
        existing.setNotes(appointment.getNotes());
        appointmentRepository.save(existing);
    }

    public void deleteAppointment(Integer id) {
        Appointment existing = appointmentRepository.findAppointmentById(id);
        if (existing == null) {
            throw new ApiException("Appointment not found");
        }
        appointmentRepository.delete(existing);
    }
    public List<Appointment> findAppointmentsByDoctorAndDate(Integer doctorId, LocalDateTime date) {
        if (doctorId == null || date == null) {
            throw new ApiException("Doctor ID and date must not be null");
        }
        return appointmentRepository.findAppointmentsByDoctorIdAndDate(doctorId, date);
    }

}
