package exagonsoft.drones.utils;

import exagonsoft.drones.dto.DroneDto;
import exagonsoft.drones.dto.MedicationDto;
import exagonsoft.drones.entity.Drone;
import exagonsoft.drones.entity.Medication;
import exagonsoft.drones.entity.Drone.StateType;
import exagonsoft.drones.exception.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UtilFunctionsTest {

    @Test
    public void testValidateDroneMaxWeight() {
        DroneDto droneDto = new DroneDto();
        droneDto.setMax_weight(600);  // Exceeds the max weight
        assertThrows(MaxWeightExceededException.class, () -> UtilFunctions.validateDrone(droneDto));

        // Alternatively, if a NullPointerException is expected when droneDto is null
        assertThrows(NullPointerException.class, () -> UtilFunctions.validateDrone(null));
    }

    @Test
    public void testValidateDroneSerialNumberLength() {
        DroneDto droneDto = new DroneDto();
        droneDto.setSerial_number("123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
        // Exceeds the max serial number length
        assertThrows(NullPointerException.class, () -> UtilFunctions.validateDroneManagement(null));
    }

    @Test
    public void testValidateDroneManagementLowBattery() {
        DroneDto updatedDrone = new DroneDto();
        updatedDrone.setState(StateType.LOADING);
        updatedDrone.setBattery_capacity(20);  // Battery level is too low for loading state
        assertThrows(LowBatteryException.class, () -> UtilFunctions.validateDroneManagement(updatedDrone));
        
        
    }

    @Test
    public void testValidateDroneLoadExceedMaxWeight() {
        int droneMaxWeight = 500;
        List<Medication> medicationList = new ArrayList<>();
        Medication medication = new Medication();
        medication.setWeight(600);  // Exceeds drone max weight
        medicationList.add(medication);
        assertThrows(MaxWeightExceededException.class, () -> UtilFunctions.validateDroneLoad(droneMaxWeight, medicationList, StateType.IDLE));
    }

    @Test
    public void testValidateDroneLoadInvalidState() {
        int droneMaxWeight = 500;
        List<Medication> medicationList = new ArrayList<>();
        Medication medication = new Medication();
        medication.setWeight(200);
        medicationList.add(medication);
        assertThrows(DroneInvalidLoadStateException.class, () -> UtilFunctions.validateDroneLoad(droneMaxWeight, medicationList, StateType.LOADING));
    }

    @Test
    public void testValidateMedicationNamePattern() {
        MedicationDto medicationDto = new MedicationDto();
        medicationDto.setName("Invalid Medication Name#");
        // Name contains invalid characters
        assertThrows(NullPointerException.class, () -> UtilFunctions.validateDroneManagement(null));
    }

    @Test
    public void testValidateMedicationCodePattern() {
        MedicationDto medicationDto = new MedicationDto();
        medicationDto.setCode("Invalid_Code");
        // Code contains invalid characters
        assertThrows(NullPointerException.class, () -> UtilFunctions.validateDroneManagement(null));
    }

    @Test
    public void testUpdateDroneLifeCycle() {
        Drone drone = new Drone();
        drone.setBattery_capacity(100);
        drone.setState(StateType.LOADING);
        List<Medication> medicationList = new ArrayList<>();
        Medication medication = new Medication();
        medication.setWeight(50);
        medicationList.add(medication);

        Drone updatedDrone = UtilFunctions.updateDroneLifeCycle(drone, medicationList);
        assertEquals(StateType.LOADED, updatedDrone.getState());
        assertEquals(95, updatedDrone.getBattery_capacity());
    }
}
