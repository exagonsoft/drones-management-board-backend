package exagonsoft.drones.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import exagonsoft.drones.entity.DroneMedications;
import exagonsoft.drones.mock.MockData;
import exagonsoft.drones.repository.DroneMedicationsRepository;
import exagonsoft.drones.service.impl.DroneMedicationServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DroneMedicationServiceTest {

    @InjectMocks
    private DroneMedicationServiceImpl droneMedicationService;

    @Mock
    private DroneMedicationsRepository droneMedicationsRepository;

    @Test
    void testListAllDroneMedications() {
        // Arrange
        Long droneId = 1L;
        when(droneMedicationsRepository.findByDroneId(droneId)).thenReturn(Arrays.asList(MockData.mockDroneMedications(), MockData.mockDroneMedications()));

        // Act
        List<DroneMedications> result = droneMedicationService.listAllDroneMedications(droneId);

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        // Add more assertions based on your DroneMedications properties
    }

    @Test
    void testCreateDroneMedication() {
        // Arrange
        DroneMedications droneMedications = MockData.mockDroneMedications();
        when(droneMedicationsRepository.save(any(DroneMedications.class))).thenReturn(MockData.mockDroneMedications());

        // Act
        DroneMedications createdDroneMedications = droneMedicationService.createDroneMedication(droneMedications);

        // Assert
        assertNotNull(createdDroneMedications);
        assertEquals(droneMedications.getId(), createdDroneMedications.getId());
        // Add more assertions based on your DroneMedications properties
    }

    @Test
    void testCleanupDroneMedication() {
        // Arrange
        Long droneId = 1L;

        // Act
        assertDoesNotThrow(() -> droneMedicationService.cleanupDroneMedication(droneId));

        // Assert
        verify(droneMedicationsRepository, times(1)).deleteAllByDroneId(droneId);
    }

    @Test
    void testListAllMedicationsIdsByDroneId() {
        // Arrange
        Long droneId = 1L;
        when(droneMedicationsRepository.listAllMedicationsIdsByDroneId(droneId)).thenReturn(Arrays.asList(1L, 2L, 3L));

        // Act
        List<Long> result = droneMedicationService.listAllMedicationsIdsByDroneId(droneId);

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(3, result.size());
        // Add more assertions based on your Long values
    }
}

