package exagonsoft.drones.service.impl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import exagonsoft.drones.dto.MedicationDto;
import exagonsoft.drones.entity.Medication;
import exagonsoft.drones.mock.MockData;
import exagonsoft.drones.repository.MedicationRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MedicationServiceImplTest {

    @InjectMocks
    private MedicationServiceImpl medicationService;

    @Mock
    private MedicationRepository medicationRepository;

    @Test
    void testGetMedication() {
        // Arrange
        Long medicationId = 1L;
        MedicationDto expectedMedicationDto = MockData.mockMedicationDto();
        when(medicationRepository.findById(medicationId)).thenReturn(Optional.of(MockData.mockMedications()));

        // Act
        MedicationDto result = medicationService.getMedication(medicationId);

        // Assert
        assertNotNull(result);
        assertEquals(expectedMedicationDto.getId(), result.getId());
        assertEquals(expectedMedicationDto.getName(), result.getName());
        // Add more assertions based on your MedicationDto properties
    }

    @Test
    void testCreateMedication() {
        // Arrange
        MedicationDto medicationDto = MockData.mockMedicationDto();
        when(medicationRepository.save(any(Medication.class))).thenReturn(MockData.mockMedications());

        // Act
        MedicationDto createdMedicationDto = medicationService.createMedication(medicationDto);

        // Assert
        assertNotNull(createdMedicationDto);
        assertEquals(medicationDto.getName(), createdMedicationDto.getName());
        // Add more assertions based on your MedicationDto properties
    }

    @Test
    void testUpdateMedication() {
        // Arrange
        Long medicationId = 1L;
        MedicationDto updatedMedicationDto = MockData.mockMedicationDto();
        when(medicationRepository.findById(medicationId)).thenReturn(Optional.of(MockData.mockMedications()));
        when(medicationRepository.save(any(Medication.class))).thenReturn(MockData.mockMedications());

        // Act
        MedicationDto result = medicationService.updateMedication(medicationId, updatedMedicationDto);

        // Assert
        assertNotNull(result);
        assertEquals(updatedMedicationDto.getName(), result.getName());
        // Add more assertions based on your MedicationDto properties
    }

    @Test
    void testGetMedicationsListByIds() {
        // Arrange
        List<Long> medicationIds = Arrays.asList(1L, 1L);
        when(medicationRepository.findAllById(medicationIds)).thenReturn(Arrays.asList(MockData.mockMedications(), MockData.mockMedications()));

        // Act
        List<Medication> result = medicationService.getMedicationsListByIds(medicationIds);

        // Assert
        assertNotNull(result);
        assertEquals(medicationIds.size(), result.size());
        // Add more assertions based on your MedicationDto properties
    }

    @Test
    void testGetMedicationById() {
        // Arrange
        Long medicationId = 1L;
        when(medicationRepository.findById(medicationId)).thenReturn(Optional.of(MockData.mockMedications()));

        // Act
        MedicationDto result = medicationService.getMedicationById(medicationId);

        // Assert
        assertNotNull(result);
        assertEquals(medicationId, result.getId());
        // Add more assertions based on your MedicationDto properties
    }

    @Test
    void testListAllMedications() {
        // Arrange
        when(medicationRepository.findAll()).thenReturn(Arrays.asList(MockData.mockMedications(), MockData.mockMedications()));

        // Act
        List<MedicationDto> result = medicationService.listAllMedications();

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        // Add more assertions based on your MedicationDto properties
    }
}

