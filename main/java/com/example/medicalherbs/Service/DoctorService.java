package com.example.medicalherbs.Service;

import com.example.medicalherbs.Model.Appointment;
import com.example.medicalherbs.Model.Doctor;
import com.example.medicalherbs.Repository.AppointmentRepository;
import com.example.medicalherbs.Repository.DoctorRepository;
import com.example.medicalherbs.ApiResponse.ApiException;
import com.example.medicalherbs.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final AppointmentService appointmentService;
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;

    public Doctor getDoctorById(Integer id) {
        if (doctorRepository.findDoctorById(id) == null) {
            throw new ApiException("Doctor not found");
        }
        return doctorRepository.findDoctorById(id);
    }
    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        return doctorRepository.findDoctorsBySpecialization(specialization);
    }
    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }
    public void updateDoctor(Integer id, Doctor doctor) {
        if (doctorRepository.findDoctorById(id) == null) {
            throw new ApiException("Doctor not found");
        }
        doctorRepository.findDoctorById(id).setName(doctor.getName());
        doctorRepository.findDoctorById(id).setSpecialization(doctor.getSpecialization());
        doctorRepository.findDoctorById(id).setHospitalId(doctor.getHospitalId());
        doctorRepository.save(doctorRepository.findDoctorById(id));

    }
    public void deleteDoctor(Integer id) {
        Doctor existing = doctorRepository.findDoctorById(id);
        if (existing == null) {
            throw new ApiException("Doctor not found");
        }
        doctorRepository.delete(existing);
    }
    private void acceptedAppointmentForPatient(Integer appointmentId,Integer patientId){
        if (patientRepository.findPatientById(patientId) == null) {
            throw new ApiException("Patient not found");
        }
        appointmentService.getAppointmentById(appointmentId).setStatus("Accepted");
        appointmentService.rejectListOfAppointmentForPatient(appointmentService.getAppointmentById(appointmentId).getPatientId()
        ,appointmentService.getAppointmentById(appointmentId).getDate(),appointmentService.getAppointmentById(appointmentId).getTime());

        appointmentService.rejectAppointmentForDoctorAtSameTimeAsCurrent(appointmentService.getAppointmentById(appointmentId));

    }

}
