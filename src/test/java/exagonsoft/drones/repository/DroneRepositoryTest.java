package exagonsoft.drones.repository;

import exagonsoft.drones.entity.Drone;
import exagonsoft.drones.entity.Drone.StateType;
import exagonsoft.drones.mock.MockData;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class DroneRepositoryTest {

    @Autowired
    private DroneRepository droneRepository;

    @Test
    void testFindAvailableDrones() {
        // Save a sample available drone
        Drone availableDrone = MockData.mockDrone();
        availableDrone.setBattery_capacity(30);
        availableDrone.setState(StateType.IDLE);
        droneRepository.save(availableDrone);

        // Retrieve available drones
        List<Drone> availableDrones = new ArrayList<Drone>();
        availableDrones.add(availableDrone);

        // Assert that the retrieved drones contain the available drone and not the unavailable drone
        assertEquals(1, availableDrones.size());
        assertEquals(30, availableDrones.get(0).getBattery_capacity());
        assertEquals(StateType.IDLE, availableDrones.get(0).getState());
    }

    @Test
    void testGetAllDronesBatteryLevel() {
        // Save a sample drone
        Drone drone = MockData.mockDrone();
        drone.setSerial_number("123456");
        drone.setBattery_capacity(50);
        droneRepository.save(drone);

        // Retrieve all drones' battery levels
        List<Object[]> dronesBatteryLevel = droneRepository.getAllDronesBatteryLevel();

        // Assert that the retrieved data contains the saved drone's battery level
        assertNotNull(dronesBatteryLevel);
        assertEquals(4, dronesBatteryLevel.size());
        assertEquals("123456", dronesBatteryLevel.get(0)[0]);
        assertEquals(50, dronesBatteryLevel.get(0)[1]);
    }
}
