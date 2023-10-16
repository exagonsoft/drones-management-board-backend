package exagonsoft.drones.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import exagonsoft.drones.entity.DroneMedications;
import exagonsoft.drones.repository.DroneMedicationsRepository;
import exagonsoft.drones.service.DroneMedicationService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DroneMedicationServiceImpl implements DroneMedicationService {

    private DroneMedicationsRepository droneMedicationsRepository;

    @Override
    public List<DroneMedications> listAllDroneMedications(Long droneID) {
        try {
            List<DroneMedications> droneMedications = droneMedicationsRepository.findByDroneId(droneID);

            return droneMedications;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public DroneMedications createDroneMedication(DroneMedications droneMedications) {
        try {
            DroneMedications savedDroneMedications = droneMedicationsRepository.save(droneMedications);
            return savedDroneMedications;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public void cleanupDroneMedication(Long droneId) {
        try {
            droneMedicationsRepository.deleteAllByDroneId(droneId);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Long> listAllMedicationsIdsByDroneId(Long droneId) {
        try {
            List<Long> droneMedicationsIds = droneMedicationsRepository.listAllMedicationsIdsByDroneId(droneId);
            return droneMedicationsIds;
        } catch (Exception e) {
           throw e;
        }
    }
}
