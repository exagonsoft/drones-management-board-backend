package exagonsoft.drones.mapper;

import exagonsoft.drones.dto.DroneMedicationDto;
import exagonsoft.drones.entity.DroneMedications;

public class DroneMedicationsMapper {
     public static DroneMedicationDto mapToDroneMedicationDto(DroneMedications droneMedication) {
        return new DroneMedicationDto(
                droneMedication.getId(),
                droneMedication.getDroneId(),
                droneMedication.getMedicationId());
    }

    public static DroneMedications mapToDrone(DroneMedicationDto droneMedicationDto) {
        return new DroneMedications(
                droneMedicationDto.getId(),
                droneMedicationDto.getDroneId(),
                droneMedicationDto.getMedicationId());
    }
}
