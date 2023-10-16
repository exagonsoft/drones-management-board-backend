package exagonsoft.drones.mapper;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import exagonsoft.drones.dto.MedicationDto;
import exagonsoft.drones.entity.Medication;
import exagonsoft.drones.mock.MockData;

public class MedicationMapperTest {

    @Test
    public void testMapToMedicationDto() {
        // Arrange
        Medication medication = MockData.mockMedications();

        // Act
        MedicationDto medicationDto = MedicationMapper.mapToMedicationDto(medication);

        // Assert
        assertEquals(medication.getId(), medicationDto.getId());
        assertEquals(medication.getName(), medicationDto.getName());
        assertEquals(medication.getWeight(), medicationDto.getWeight());
        assertEquals(medication.getCode(), medicationDto.getCode());
        assertEquals(medication.getImageUrl(), medicationDto.getImageUrl());
    }

    @Test
    public void testMapToMedication() {
        // Arrange
        MedicationDto medicationDto = MockData.mockMedicationDto();

        // Act
        Medication medication = MedicationMapper.mapToMedication(medicationDto);

        // Assert
        assertEquals(medicationDto.getId(), medication.getId());
        assertEquals(medicationDto.getName(), medication.getName());
        assertEquals(medicationDto.getWeight(), medication.getWeight());
        assertEquals(medicationDto.getCode(), medication.getCode());
        assertEquals(medicationDto.getImageUrl(), medication.getImageUrl());
    }
}
