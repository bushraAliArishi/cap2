package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificationRepository extends JpaRepository<Certification, Integer> {
    Certification findCertificationById(Integer id);

    Certification findCertificationByName(String name);

    @Query("SELECT c FROM Certification c WHERE c.issuingOrganization = ?1")
    List<Certification> findCertificationByIssuingOrganization(String organization);
}
