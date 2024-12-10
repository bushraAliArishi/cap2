package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.DoctorInstruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorInstructionRepository extends JpaRepository<DoctorInstruction, Integer> {

    List<DoctorInstruction> findByDoctorId(Integer doctorId);
    List<DoctorInstruction> findAll();
    List<DoctorInstruction> findByUserId(Integer userId);
    List<DoctorInstruction> findByCaseHistoryId(Integer caseHistoryId);

    DoctorInstruction findDoctorInstructionById(Integer id);

}
