package com.example.medicalherbs.Service;

import com.example.medicalherbs.Model.Hospital;
import com.example.medicalherbs.Repository.HospitalRepository;
import com.example.medicalherbs.ApiResponse.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public Hospital getHospitalById(Integer id) {
        Hospital hospital = hospitalRepository.findHospitalById(id);
        if (hospital == null) {
            throw new ApiException("Hospital not found");
        }
        return hospital;
    }
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }
  public List<Hospital> getHospitalsByLocation(String location) {
        return hospitalRepository.findHospitalsByLocation(location);
    }

    public void addHospital(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    public void updateHospital(Integer id, Hospital hospital) {
        Hospital existing = hospitalRepository.findHospitalById(id);
        if (existing == null) {
            throw new ApiException("Hospital not found");
        }
        existing.setName(hospital.getName());
        existing.setLocation(hospital.getLocation());
        existing.setStartWorkHour(hospital.getStartWorkHour());
        existing.setCloseWorkHour(hospital.getCloseWorkHour());
        hospitalRepository.save(existing);
    }

    public void deleteHospital(Integer id) {
        Hospital existing = hospitalRepository.findHospitalById(id);
        if (existing == null) {
            throw new ApiException("Hospital not found");
        }
        hospitalRepository.delete(existing);
    }
}
