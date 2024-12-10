package com.example.medicalherbs.Service;

import com.example.medicalherbs.ApiResponse.ApiException;
import com.example.medicalherbs.Model.Appointment;
import com.example.medicalherbs.Model.Patient;
import com.example.medicalherbs.Repository.DoctorAvailabilityRepository;
import com.example.medicalherbs.Repository.ListOfUserAndDiseasesRepository;
import com.example.medicalherbs.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final AppointmentService appointmentService;
    private final ListOfUserAndDiseasesService listOfUserAndDiseasesService;
    private final ListOfUserAndDiseasesRepository listOfUserAndDiseasesRepository;
    private final DoctorAvailabilityRepository doctorAvailabilityRepository;


    public Patient getPatientById(Integer id) {
        Patient user = patientRepository.findPatientById(id);
        if (user == null) {
            throw new ApiException("Patient not found");
        }
        return user;
    }
    public Patient getPatientByEmail(String email) {
        Patient user = patientRepository.findPatientByEmail(email);
        if (user == null) {
            throw new ApiException("Patient not found");
        }
        return user;
    }
    public void addPatient(Patient user) {
        if (user.getUsername().isEmpty() || user.getEmail().isEmpty()) {
            throw new ApiException("Username and email must not be empty");
        }
        patientRepository.save(user);
    }
    public void updatePatient(Integer id, Patient patient) {
        Patient existing = patientRepository.findPatientById(id);
        if (existing == null) {
            throw new ApiException("Patient not found");
        }
        patientRepository.delete(existing);
    }
    public void deletePatient(Integer id) {
        Patient patient = patientRepository.findPatientById(id);
        if (patient == null) {
            throw new ApiException("Patient not found");
        }
        patientRepository.delete(patient);
    }
    public void requestAppointmentForPatient(Appointment appointment,Integer patientID){
        if (patientRepository.findPatientById(patientID)==null){
            throw new ApiException("Patient not found");
        }
        if (appointmentService.getAppointmentsByPatientIdAndDateAndTimeAndStatus(appointment.getPatientId(),
                appointment.getDate(),appointment.getTime(),"Accepted")!=null){
            throw new ApiException("Patient has active appointment at the same time");
        }
        if (doctorAvailabilityRepository.findDoctorAvailabilityByDoctorId(appointment.getDoctorId()).getStartTime().isAfter(appointment.getTime())
            ||doctorAvailabilityRepository.findDoctorAvailabilityByDoctorId(appointment.getDoctorId()).getEndTime().isBefore(appointment.getTime())){
            throw new ApiException("doctor not Available in this time  ");
        }
        if (appointmentService.getAppointmentsByDoctorIdAndDateAndTimeAndStatus(appointment.getDoctorId(),
                appointment.getDate(),appointment.getTime(),"Accepted")!=null){
            throw new ApiException("doctor not Available in this time  ");
        }
        appointmentService.addAppointment(appointment);

    }
}
