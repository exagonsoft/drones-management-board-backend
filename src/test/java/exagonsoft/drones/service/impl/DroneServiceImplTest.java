package exagonsoft.drones.service.impl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import exagonsoft.drones.dto.BatteryLevelDto;
import exagonsoft.drones.dto.DroneDto;
import exagonsoft.drones.dto.MedicationDto;
import exagonsoft.drones.entity.Drone;
import exagonsoft.drones.repository.DroneRepository;
import exagonsoft.drones.service.DroneMedicationService;
import exagonsoft.drones.service.MedicationService;
import exagonsoft.drones.mock.MockData;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DroneServiceImplTest {

    @InjectMocks
    private DroneServiceImpl droneService;

    @Mock
    private DroneRepository droneRepository;

    @Mock
    private DroneMedicationService droneMedicationService;

    @Mock
    private MedicationService medicationService;

    @Test
    public void testCreateDrone() {
        // Arrange
        DroneDto droneDto = MockData.mockDroneDto();
        Drone savedDrone = MockData.mockDrone();
        when(droneRepository.save(any(Drone.class))).thenReturn(savedDrone);

        // Act
        DroneDto createdDrone = droneService.createDrone(droneDto);

        // Assert
        assertNotNull(createdDrone);
        assertEquals(savedDrone.getId(), createdDrone.getId());
    }

    @Test
    public void testGetDroneByID() {
        // Arrange
        Long droneId = 1L;
        Drone drone = MockData.mockDrone();
        when(droneRepository.findById(droneId)).thenReturn(Optional.of(drone));

        // Act
        DroneDto retrievedDrone = droneService.getDroneByID(droneId);

        // Assert
        assertNotNull(retrievedDrone);
        assertEquals(droneId, retrievedDrone.getId());
    }

    @Test
    public void testListAllDrones() {
        // Arrange
        List<Drone> drones = Collections.singletonList(MockData.mockDrone());
        when(droneRepository.findAll()).thenReturn(drones);

        // Act
        List<DroneDto> droneDtoList = droneService.listAllDrones();

        // Assert
        assertNotNull(droneDtoList);
        assertEquals(1, droneDtoList.size());
    }

    @Test
    public void testUpdateDrone() {
        // Arrange
        Long droneId = 1L;
        DroneDto updatedDroneDto = MockData.mockDroneDto();
        Drone existingDrone = MockData.mockDrone();
        when(droneRepository.findById(droneId)).thenReturn(Optional.of(existingDrone));
        when(droneRepository.save(any(Drone.class))).thenReturn(existingDrone);

        // Act
        DroneDto updatedDrone = droneService.updateDrone(droneId, updatedDroneDto);

        // Assert
        assertNotNull(updatedDrone);
        assertEquals(updatedDroneDto.getMax_weight(), updatedDrone.getMax_weight());
        assertEquals(updatedDroneDto.getModel(), updatedDrone.getModel());
        assertEquals(updatedDroneDto.getBattery_capacity(), updatedDrone.getBattery_capacity());
        assertEquals(updatedDroneDto.getState(), updatedDrone.getState());
    }

    @Test
    public void testListAvailableDrones() {
        // Arrange
        List<Drone> availableDrones = Collections.singletonList(MockData.mockDrone());
        when(droneRepository.findAvailableDrones()).thenReturn(availableDrones);

        // Act
        List<DroneDto> availableDroneDtoList = droneService.listAvailableDrones();

        // Assert
        assertNotNull(availableDroneDtoList);
        assertEquals(1, availableDroneDtoList.size());
    }

    @Test
    public void testCheckDroneBatteryLevel() {
        // Arrange
        Long droneId = 1L;
        Drone drone = MockData.mockDrone();
        when(droneRepository.findById(droneId)).thenReturn(Optional.of(drone));

        // Act
        BatteryLevelDto batteryLevelDto = droneService.checkDroneBatteryLevel(droneId);

        // Assert
        assertNotNull(batteryLevelDto);
        assertEquals(drone.getBattery_capacity(), batteryLevelDto.getBatteryLevel());
    }

    @Test
    public void testListDroneMedications() {
        // Arrange
        Long droneId = 1L;
        Drone drone = MockData.mockDrone();
        when(droneRepository.findById(droneId)).thenReturn(Optional.of(drone));
        when(droneMedicationService.listAllDroneMedications(droneId))
            .thenReturn(Collections.singletonList(MockData.mockDroneMedications()));
        when(medicationService.getMedication(Mockito.anyLong()))
            .thenReturn(MockData.mockMedicationDto());

        // Act
        List<MedicationDto> medicationDtoList = droneService.listDroneMedications(droneId);

        // Assert
        assertNotNull(medicationDtoList);
        assertFalse(medicationDtoList.isEmpty());
    }

    @Test
    public void testLoadDroneMedications() {
        // Arrange
        Long droneId = 1L;
        List<Long> medicationsIds = Collections.singletonList(1L);
        Drone drone = MockData.mockDrone();
        when(droneRepository.findById(droneId)).thenReturn(Optional.of(drone));
        when(medicationService.getMedicationsListByIds(medicationsIds))
            .thenReturn(Collections.singletonList(MockData.mockMedications()));

        // Act
        boolean result = droneService.loadDroneMedications(droneId, medicationsIds);

        // Assert
        assertTrue(result);
        verify(droneMedicationService, times(1)).cleanupDroneMedication(droneId);
    }
}
