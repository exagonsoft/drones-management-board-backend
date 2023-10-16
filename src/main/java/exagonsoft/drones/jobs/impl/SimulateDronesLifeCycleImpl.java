package exagonsoft.drones.jobs.impl;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import exagonsoft.drones.entity.Drone;
import exagonsoft.drones.entity.Medication;
import exagonsoft.drones.entity.Drone.StateType;
import exagonsoft.drones.jobs.SimulationSystemService;
import exagonsoft.drones.repository.DroneRepository;
import exagonsoft.drones.service.DroneMedicationService;
import exagonsoft.drones.service.MedicationService;
import exagonsoft.drones.utils.UtilFunctions;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SimulateDronesLifeCycleImpl implements SimulationSystemService {
    private DroneRepository droneRepository;
    private DroneMedicationService droneMedicationService;
    private MedicationService medicationService;

    @Override
    @Scheduled(fixedRate = 120000)
    public void simulateDronesLifeCycle() {
        String header = "Simulating Drones Life Cycle New State";
        String message = "";
        try {
            List<Drone> drones = droneRepository.findAll();
            for (Drone drone : drones) {
                List<Long> droneMedicationsList = droneMedicationService.listAllMedicationsIdsByDroneId(drone.getId());
                List<Medication> medicationList = medicationService.getMedicationsListByIds(droneMedicationsList);
                Drone updatedDrone = UtilFunctions.updateDroneLifeCycle(drone, medicationList);
                if (updatedDrone.getState() == StateType.DELIVERED) {
                    droneMedicationService.cleanupDroneMedication(drone.getId());
                }
                droneRepository.save(updatedDrone);
                message += "--Drone " + drone.getSerial_number() + " is now " + updatedDrone.getState() + "\n";
            }
            UtilFunctions.printInfo(header, message);
        } catch (Exception e) {
            throw e;
        }
    }

}
