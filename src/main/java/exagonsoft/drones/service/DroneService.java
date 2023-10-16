package exagonsoft.drones.service;

import java.util.List;

import exagonsoft.drones.dto.BatteryLevelDto;
import exagonsoft.drones.dto.DroneDto;
import exagonsoft.drones.dto.MedicationDto;

public interface DroneService {
    DroneDto createDrone(DroneDto droneDto);

    DroneDto getDroneByID(Long droneID);

    List<DroneDto> listAllDrones();

    DroneDto updateDrone(Long id, DroneDto updatedDrone);

    List<DroneDto> listAvailableDrones();

    BatteryLevelDto checkDroneBatteryLevel(Long droneID);

    List<MedicationDto> listDroneMedications(Long droneID);

    boolean loadDroneMedications(Long droneID, List<Long> medicationsIds);
}
