package exagonsoft.drones.jobs.impl;

import exagonsoft.drones.entity.Drone;
import exagonsoft.drones.entity.Medication;
import exagonsoft.drones.entity.Drone.StateType;
import exagonsoft.drones.mock.MockData;
import exagonsoft.drones.repository.DroneRepository;
import exagonsoft.drones.service.DroneMedicationService;
import exagonsoft.drones.service.MedicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
class SimulateDronesLifeCycleImplTest {

    @Mock
    private DroneRepository droneRepository;

    @Mock
    private DroneMedicationService droneMedicationService;

    @Mock
    private MedicationService medicationService;

    @InjectMocks
    private SimulateDronesLifeCycleImpl simulateDronesLifeCycle;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSimulateDronesLifeCycle() {
        // Arrange
        Drone drone = MockData.mockDrone();
        drone.setId(1L);
        drone.setSerial_number("Serial123");
        drone.setState(StateType.IDLE);
        List<Drone> drones = new ArrayList<>();
        drones.add(drone);

        List<Long> medicationIds = new ArrayList<>();
        medicationIds.add(1L);

        Medication medication = MockData.mockMedications();
        medication.setId(1L);
        medication.setName("Medication1");
        List<Medication> medications = new ArrayList<>();
        medications.add(medication);

        when(droneRepository.findAll()).thenReturn(drones);
        when(droneMedicationService.listAllMedicationsIdsByDroneId(1L)).thenReturn(medicationIds);
        when(medicationService.getMedicationsListByIds(medicationIds)).thenReturn(medications);
        when(droneRepository.save(any(Drone.class))).thenReturn(drone);

        // Act
        simulateDronesLifeCycle.simulateDronesLifeCycle();

        // Assert
        verify(droneMedicationService, times(1)).listAllMedicationsIdsByDroneId(1L);
        verify(medicationService, times(1)).getMedicationsListByIds(medicationIds);
        verify(droneRepository, times(1)).save(drone);
    }
}
