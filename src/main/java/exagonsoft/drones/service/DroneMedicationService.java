package exagonsoft.drones.service;

import java.util.List;

import exagonsoft.drones.entity.DroneMedications;
import jakarta.transaction.Transactional;

public interface DroneMedicationService {
    List<DroneMedications> listAllDroneMedications(Long droneID);
    DroneMedications createDroneMedication(DroneMedications droneMedications);

    @Transactional
    void cleanupDroneMedication(Long droneId);
    
    List<Long> listAllMedicationsIdsByDroneId(Long droneId);
}
