package exagonsoft.drones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import exagonsoft.drones.entity.Medication;

public interface MedicationRepository extends JpaRepository<Medication, Long> {

}
