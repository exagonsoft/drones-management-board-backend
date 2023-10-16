package exagonsoft.drones.mapper;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import exagonsoft.drones.dto.DroneMedicationDto;
import exagonsoft.drones.entity.DroneMedications;

public class DroneMedicationsMapperTest {

    @Test
    public void testMapToDroneMedicationDto() {
        // Arrange
        DroneMedications droneMedications = new DroneMedications(1L, 1L, 1L);

        // Act
        DroneMedicationDto droneMedicationDto = DroneMedicationsMapper.mapToDroneMedicationDto(droneMedications);

        // Assert
        assertEquals(droneMedications.getId(), droneMedicationDto.getId());
        assertEquals(droneMedications.getDroneId(), droneMedicationDto.getDroneId());
        assertEquals(droneMedications.getMedicationId(), droneMedicationDto.getMedicationId());
    }

    @Test
    public void testMapToDroneMedications() {
        // Arrange
        DroneMedicationDto droneMedicationDto = new DroneMedicationDto(1L, 1L, 1L);

        // Act
        DroneMedications droneMedications = DroneMedicationsMapper.mapToDrone(droneMedicationDto);

        // Assert
        assertEquals(droneMedicationDto.getId(), droneMedications.getId());
        assertEquals(droneMedicationDto.getDroneId(), droneMedications.getDroneId());
        assertEquals(droneMedicationDto.getMedicationId(), droneMedications.getMedicationId());
    }
}
