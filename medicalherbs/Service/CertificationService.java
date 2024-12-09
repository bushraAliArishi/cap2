package com.example.medicalherbs.Service;

import com.example.medicalherbs.ApiResponse.ApiException;
import com.example.medicalherbs.Model.Certification;
import com.example.medicalherbs.Repository.CertificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificationService {
    private final CertificationRepository certificationRepository;

    public Certification getCertificationById(Integer id) {
        Certification certification = certificationRepository.findCertificationById(id);
        if (certification == null) {
            throw new ApiException("Certification not found");
        }
        return certification;
    }

    public Certification getCertificationByName(String name) {
        Certification certification = certificationRepository.findCertificationByName(name);
        if (certification == null) {
            throw new ApiException("Certification not found");
        }
        return certification;
    }

    public List<Certification> getCertificationsByOrganization(String organization) {
        List<Certification> certifications = certificationRepository.findCertificationByIssuingOrganization(organization);
        if (certifications.isEmpty()) {
            throw new ApiException("No certifications found for the specified organization");
        }
        return certifications;
    }

    public void addCertification(Certification certification) {
        if (certification.getName().isEmpty() || certification.getIssuingOrganization().isEmpty()) {
            throw new ApiException("Certification name and issuing organization cannot be empty");
        }
        certificationRepository.save(certification);
    }

    public void updateCertification(Integer id, Certification certification) {
        Certification existing = certificationRepository.findCertificationById(id);
        if (existing != null) {
            existing.setName(certification.getName());
            existing.setIssuingOrganization(certification.getIssuingOrganization());
            existing.setDateIssued(certification.getDateIssued());
            certificationRepository.save(existing);
        } else {
            throw new ApiException("Certification not found");
        }
    }

    public void deleteCertification(Integer id) {
        Certification existing = certificationRepository.findCertificationById(id);
        if (existing != null) {
            certificationRepository.delete(existing);
        } else {
            throw new ApiException("Certification not found");
        }
    }
}
