package com.example.medicalherbs.Service;

import com.example.medicalherbs.Model.Doctor;
import com.example.medicalherbs.Repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public Doctor getDoctorById(Integer id) {
        return doctorRepository.findDoctorById(id);
    }

    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        return doctorRepository.findDoctorBySpecialization(specialization);
    }

    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public void updateDoctor(Integer id, Doctor doctor) {
        Doctor existing = doctorRepository.findDoctorById(id);
        if (existing != null) {
            existing.setName(doctor.getName());
            existing.setSpecialization(doctor.getSpecialization());
            existing.setContactInfo(doctor.getContactInfo());
            doctorRepository.save(existing);
        } else {
            throw new IllegalArgumentException("Doctor not found");
        }
    }

    public void deleteDoctor(Integer id) {
        Doctor existing = doctorRepository.findDoctorById(id);
        if (existing != null) {
            doctorRepository.delete(existing);
        } else {
            throw new IllegalArgumentException("Doctor not found");
        }
    }
}
