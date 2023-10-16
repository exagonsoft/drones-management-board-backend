package exagonsoft.drones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import exagonsoft.drones.entity.Drone;

public interface DroneRepository extends JpaRepository<Drone, Long> {
    @Query(value = "SELECT * FROM drones WHERE battery_capacity >= 25 AND state = 'IDLE'", nativeQuery = true)
    List<Drone> findAvailableDrones();

    @Query(value = "SELECT serial_number, battery_capacity, id FROM drones" , nativeQuery = true)
    List<Object[]> getAllDronesBatteryLevel();
}
