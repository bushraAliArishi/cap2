package com.example.medicalherbs.Service;

import com.example.medicalherbs.Model.Medicine;
import com.example.medicalherbs.Repository.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineService {
    private final MedicineRepository medicineRepository;

    public Medicine getMedicineById(Integer id) {
        return medicineRepository.findMedicineById(id);
    }

    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    public void addMedicine(Medicine medicine) {
        medicineRepository.save(medicine);
    }

    public void updateMedicine(Integer id, Medicine medicine) {
        Medicine existing = medicineRepository.findMedicineById(id);
        if (existing != null) {
            existing.setName(medicine.getName());
            existing.setDescription(medicine.getDescription());
            medicineRepository.save(existing);
        } else {
            throw new RuntimeException("Medicine not found");
        }
    }

    public void deleteMedicine(Integer id) {
        Medicine existing = medicineRepository.findMedicineById(id);
        if (existing != null) {
            medicineRepository.delete(existing);
        } else {
            throw new RuntimeException("Medicine not found");
        }
    }
}
