package exagonsoft.drones.mapper;

import exagonsoft.drones.dto.MedicationDto;
import exagonsoft.drones.entity.Medication;

public class MedicationMapper {
    public static MedicationDto mapToMedicationDto(Medication medication) {
        return new MedicationDto(
                medication.getId(),
                medication.getName(),
                medication.getWeight(),
                medication.getCode(),
                medication.getImageUrl());
    }

    public static Medication mapToMedication(MedicationDto medicationDto) {
        return new Medication(
                medicationDto.getId(),
                medicationDto.getName(),
                medicationDto.getWeight(),
                medicationDto.getCode(),
                medicationDto.getImageUrl());
    }
}
