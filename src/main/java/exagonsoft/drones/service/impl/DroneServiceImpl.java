package exagonsoft.drones.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import exagonsoft.drones.dto.BatteryLevelDto;
import exagonsoft.drones.dto.DroneDto;
import exagonsoft.drones.dto.MedicationDto;
import exagonsoft.drones.entity.Drone;
import exagonsoft.drones.entity.DroneMedications;
import exagonsoft.drones.entity.Medication;
import exagonsoft.drones.entity.Drone.StateType;
import exagonsoft.drones.exception.DuplicateSerialNumberException;
import exagonsoft.drones.exception.ResourceNotFoundException;
import exagonsoft.drones.mapper.DroneMapper;
import exagonsoft.drones.repository.DroneRepository;
import exagonsoft.drones.service.DroneMedicationService;
import exagonsoft.drones.service.DroneService;
import exagonsoft.drones.service.MedicationService;
import exagonsoft.drones.utils.UtilFunctions;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DroneServiceImpl implements DroneService {

    private DroneRepository droneRepository;
    private DroneMedicationService droneMedicationService;
    private MedicationService medicationService;

    @Override
    public DroneDto createDrone(DroneDto droneDto) {

        try {
            // *Validate the Drone Data*/
            UtilFunctions.validateDrone(droneDto);

            Drone drone = DroneMapper.mapToDrone(droneDto);

            Drone savedDrone = droneRepository.save(drone);

            return DroneMapper.mapToDroneDto(savedDrone);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateSerialNumberException("Serial Number already exists!");
        }

    }

    @Override
    public DroneDto getDroneByID(Long droneID) {
        Drone drone = droneRepository.findById(droneID)
                .orElseThrow(() -> new ResourceNotFoundException("Drone not found with given id: " + droneID));

        return DroneMapper.mapToDroneDto(drone);
    }

    @Override
    public List<DroneDto> listAllDrones() {
        try {
            List<Drone> drones = droneRepository.findAll();

            return drones.stream().map((drone) -> DroneMapper.mapToDroneDto(drone))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong!");
        }

    }

    @Override
    public DroneDto updateDrone(Long droneId, DroneDto updatedDrone) {

        try {
            // *Validate the Drone Data*/
            UtilFunctions.validateDrone(updatedDrone);
            UtilFunctions.validateDroneManagement(updatedDrone);

            Drone drone = droneRepository.findById(droneId)
                    .orElseThrow(() -> new ResourceNotFoundException("Drone not found with given id: " + droneId));

            drone.setMax_weight(updatedDrone.getMax_weight());
            drone.setModel(updatedDrone.getModel());
            drone.setBattery_capacity(updatedDrone.getBattery_capacity());
            drone.setState(updatedDrone.getState());

            Drone updatedDroneObj = droneRepository.save(drone);

            return DroneMapper.mapToDroneDto(updatedDroneObj);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<DroneDto> listAvailableDrones() {
        try {
            List<Drone> drones = droneRepository.findAvailableDrones();

            return drones.stream().map((drone) -> DroneMapper.mapToDroneDto(drone))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong!");
        }
    }

    @Override
    public BatteryLevelDto checkDroneBatteryLevel(Long droneID) {
        try {
            Drone drone = droneRepository.findById(droneID)
                    .orElseThrow(() -> new ResourceNotFoundException("Drone not found with given id: " + droneID));

            BatteryLevelDto batteryLevelDto = new BatteryLevelDto(drone.getBattery_capacity());

            return batteryLevelDto;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public List<MedicationDto> listDroneMedications(Long droneID) {
        try {
            droneRepository.findById(droneID)
                    .orElseThrow(() -> new ResourceNotFoundException("Drone not found with given id: " + droneID));

            List<DroneMedications> droneMedications = droneMedicationService.listAllDroneMedications(droneID);

            List<MedicationDto> medicationDtoList = droneMedications.stream()
                    .map((_drone_medication) -> medicationService.getMedication(_drone_medication.getMedicationId()))
                    .collect(Collectors.toList());

            return medicationDtoList;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean loadDroneMedications(Long droneID, List<Long> medicationsIds) {

        try {
            Drone drone = droneRepository.findById(droneID)
                    .orElseThrow(() -> new ResourceNotFoundException("Drone not found with given id: " + droneID));

            List<Medication> medicationList = medicationService.getMedicationsListByIds(medicationsIds);

            UtilFunctions.validateDroneLoad(drone.getMax_weight(), medicationList, drone.getState());
            drone.setState(StateType.LOADING);
            UtilFunctions.validateDroneManagement(DroneMapper.mapToDroneDto(drone));

            droneRepository.save(drone);
            droneMedicationService.cleanupDroneMedication(droneID);
            for (Medication medication : medicationList) {
                DroneMedications droneMedication = new DroneMedications();
                droneMedication.setDroneId(droneID);
                droneMedication.setMedicationId(medication.getId());
                droneMedicationService.createDroneMedication(droneMedication);
            }

            return true;
        } catch (Exception e) {
            throw e;
        }
    }

}
