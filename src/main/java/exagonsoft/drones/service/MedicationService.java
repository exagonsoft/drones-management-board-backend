package exagonsoft.drones.service;

import java.util.List;

import exagonsoft.drones.dto.MedicationDto;
import exagonsoft.drones.entity.Medication;

public interface MedicationService {
    MedicationDto getMedication(Long medicationID);

    MedicationDto createMedication(MedicationDto medicationDto);

    MedicationDto updateMedication(Long id, MedicationDto medicationDto);

    void deleteMedication(Long medicationID);

    MedicationDto getMedicationById(Long medicationId);

    List<MedicationDto> listAllMedications();

    List<Medication> getMedicationsListByIds(List<Long> medicationIds);
}
