package exagonsoft.drones.mock;

import exagonsoft.drones.dto.*;
import exagonsoft.drones.entity.*;
import exagonsoft.drones.entity.Drone.ModelType;
import exagonsoft.drones.entity.Drone.StateType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MockDataTest {

    @Test
    void testMockDrone() {
        Drone drone = MockData.mockDrone();
        assertEquals(1L, drone.getId());
        assertEquals("mxzn6789", drone.getSerial_number());
        assertEquals(250, drone.getMax_weight());
        assertEquals(ModelType.Cruiserweight, drone.getModel());
        assertEquals(100, drone.getBattery_capacity());
        assertEquals(StateType.IDLE, drone.getState());
    }

    @Test
    void testMockDroneDto() {
        DroneDto droneDto = MockData.mockDroneDto();
        assertEquals(1L, droneDto.getId());
        assertEquals("mxzn6789", droneDto.getSerial_number());
        assertEquals(250, droneDto.getMax_weight());
        assertEquals(ModelType.Cruiserweight, droneDto.getModel());
        assertEquals(100, droneDto.getBattery_capacity());
        assertEquals(StateType.IDLE, droneDto.getState());
    }

    // Add similar test methods for other mock data methods...
}
