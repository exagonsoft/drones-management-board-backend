package exagonsoft.drones.repository;

import exagonsoft.drones.entity.DroneMedications;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class DroneMedicationsRepositoryTest {

    @Autowired
    private DroneMedicationsRepository droneMedicationsRepository;

    @Test
    void testFindByDroneId() {
        // Save a sample DroneMedications with a specific drone ID
        long droneId = 1L;
        DroneMedications droneMedications = new DroneMedications();
        droneMedications.setDroneId(droneId);
        droneMedications.setMedicationId(1L);
        droneMedicationsRepository.save(droneMedications);

        // Retrieve DroneMedications for the specific drone ID
        List<DroneMedications> droneMedicationsList = droneMedicationsRepository.findByDroneId(droneId);

        // Assert that the retrieved DroneMedications contain the saved DroneMedications
        assertEquals(1, droneMedicationsList.size());
        assertEquals(1L, droneMedicationsList.get(0).getMedicationId());
    }

    @Test
    void testDeleteAllByDroneId() {
        // Save a sample DroneMedications with a specific drone ID
        long droneId = 1L;
        DroneMedications droneMedications = new DroneMedications();
        droneMedications.setDroneId(droneId);
        droneMedications.setMedicationId(1L);
        droneMedicationsRepository.save(droneMedications);

        // Delete DroneMedications for the specific drone ID
        droneMedicationsRepository.deleteAllByDroneId(droneId);

        // Retrieve DroneMedications for the specific drone ID after deletion
        List<DroneMedications> droneMedicationsList = droneMedicationsRepository.findByDroneId(droneId);

        // Assert that no DroneMedications are retrieved after deletion
        assertEquals(0, droneMedicationsList.size());
    }

    @Test
    void testListAllMedicationsIdsByDroneId() {
        // Save a sample DroneMedications with a specific drone ID
        long droneId = 1L;
        DroneMedications droneMedications = new DroneMedications();
        droneMedications.setDroneId(droneId);
        droneMedications.setMedicationId(1L);
        droneMedicationsRepository.save(droneMedications);

        // Retrieve medication IDs for the specific drone ID
        List<Long> medicationIds = droneMedicationsRepository.listAllMedicationsIdsByDroneId(droneId);

        // Assert that the retrieved medication IDs contain the saved medication ID
        assertEquals(1, medicationIds.size());
        assertEquals(1L, medicationIds.get(0));
    }
}
