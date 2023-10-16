package exagonsoft.drones.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exagonsoft.drones.dto.MedicationDto;
import exagonsoft.drones.service.MedicationService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/medications")
public class MedicationController {
    private MedicationService medicationService;

    @PostMapping
    public ResponseEntity<MedicationDto> createMedication(@RequestBody MedicationDto MedicationDto) {
        try {
            MedicationDto savedMedication = medicationService.createMedication(MedicationDto);

            return new ResponseEntity<>(savedMedication, HttpStatus.CREATED);
        } catch (Exception e) {
            throw e;
        }

    }

    @GetMapping("{id}")
    public ResponseEntity<MedicationDto> getMedicationById(@PathVariable("id") Long MedicationID) {
        MedicationDto MedicationDto = medicationService.getMedicationById(MedicationID);

        return ResponseEntity.ok(MedicationDto);
    }

    @GetMapping
    public ResponseEntity<List<MedicationDto>> getAllMedications() {
        List<MedicationDto> MedicationList = medicationService.listAllMedications();

        return ResponseEntity.ok(MedicationList);
    }

    @PutMapping("{id}")
    public ResponseEntity<MedicationDto> updateMedication(@PathVariable("id") Long MedicationID, @RequestBody MedicationDto updatedMedication) {
        MedicationDto MedicationDto = medicationService.updateMedication(MedicationID, updatedMedication);
        return ResponseEntity.ok(MedicationDto);
    }

}
