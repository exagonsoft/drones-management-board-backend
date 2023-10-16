package exagonsoft.drones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import exagonsoft.drones.entity.DroneMedications;

public interface DroneMedicationsRepository extends JpaRepository<DroneMedications, Long> {
    List<DroneMedications> findByDroneId(Long droneId);
    
    @Modifying
    @Query(value = "DELETE FROM drone_medications WHERE drone_id = :droneId" , nativeQuery = true)
    void deleteAllByDroneId(@Param("droneId") Long droneId);
    
    @Query(value = "SELECT medication_id FROM drone_medications WHERE drone_id = :droneId" , nativeQuery = true)
    List<Long> listAllMedicationsIdsByDroneId(@Param("droneId") Long droneId);


}
