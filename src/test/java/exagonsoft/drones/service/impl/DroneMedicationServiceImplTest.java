package exagonsoft.drones.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import exagonsoft.drones.entity.DroneMedications;
import exagonsoft.drones.repository.DroneMedicationsRepository;

@SpringBootTest
class DroneMedicationServiceImplTest {

    private final DroneMedicationsRepository droneMedicationsRepository = mock(DroneMedicationsRepository.class);
    private final DroneMedicationServiceImpl droneMedicationService = new DroneMedicationServiceImpl(droneMedicationsRepository);

    @Test
    void testListAllDroneMedications() {
        // Arrange
        Long droneId = 1L;
        List<DroneMedications> expectedDroneMedications = Arrays.asList(new DroneMedications(), new DroneMedications());
        when(droneMedicationsRepository.findByDroneId(droneId)).thenReturn(expectedDroneMedications);

        // Act
        List<DroneMedications> result = droneMedicationService.listAllDroneMedications(droneId);

        // Assert
        assertEquals(expectedDroneMedications, result);
    }

    @Test
    void testCreateDroneMedication() {
        // Arrange
        DroneMedications inputDroneMedications = new DroneMedications();
        DroneMedications savedDroneMedications = new DroneMedications();
        when(droneMedicationsRepository.save(inputDroneMedications)).thenReturn(savedDroneMedications);

        // Act
        DroneMedications result = droneMedicationService.createDroneMedication(inputDroneMedications);

        // Assert
        assertEquals(savedDroneMedications, result);
    }

    @Test
    void testCleanupDroneMedication() {
        // Arrange
        Long droneId = 1L;

        // Act
        droneMedicationService.cleanupDroneMedication(droneId);

        // Assert
        verify(droneMedicationsRepository, times(1)).deleteAllByDroneId(droneId);
    }

    @Test
    void testListAllMedicationsIdsByDroneId() {
        // Arrange
        Long droneId = 1L;
        List<Long> expectedMedicationsIds = Arrays.asList(1L, 2L, 3L);
        when(droneMedicationsRepository.listAllMedicationsIdsByDroneId(droneId)).thenReturn(expectedMedicationsIds);

        // Act
        List<Long> result = droneMedicationService.listAllMedicationsIdsByDroneId(droneId);

        // Assert
        assertEquals(expectedMedicationsIds, result);
    }
}

