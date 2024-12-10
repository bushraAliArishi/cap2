package com.example.medicalherbs.Controller;

import com.example.medicalherbs.Model.Medicine;
import com.example.medicalherbs.Service.MedicineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/medicine")
@RequiredArgsConstructor
public class MedicineController {
    private final MedicineService medicineService;

    @GetMapping("/getById/{id}")
    public ResponseEntity getMedicineById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(medicineService.getMedicineById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity getAllMedicines() {
        return ResponseEntity.status(200).body(medicineService.getAllMedicines());
    }

    @PostMapping("/add")
    public ResponseEntity addMedicine(@RequestBody @Valid Medicine medicine) {
        medicineService.addMedicine(medicine);
        return ResponseEntity.status(200).body("Medicine added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMedicine(@PathVariable Integer id, @RequestBody @Valid Medicine medicine) {
        medicineService.updateMedicine(id, medicine);
        return ResponseEntity.status(200).body("Medicine updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMedicine(@PathVariable Integer id) {
        medicineService.deleteMedicine(id);
        return ResponseEntity.status(200).body("Medicine deleted successfully");
    }
}
