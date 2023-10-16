package exagonsoft.drones.mapper;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import exagonsoft.drones.dto.DroneDto;
import exagonsoft.drones.entity.Drone;
import exagonsoft.drones.mock.MockData;

public class DroneMapperTest {

    @Test
    public void testMapToDroneDto() {
        // Arrange
        Drone drone = MockData.mockDrone();

        // Act
        DroneDto droneDto = DroneMapper.mapToDroneDto(drone);

        // Assert
        assertEquals(drone.getId(), droneDto.getId());
        assertEquals(drone.getSerial_number(), droneDto.getSerial_number());
        assertEquals(drone.getModel(), droneDto.getModel());
        assertEquals(drone.getMax_weight(), droneDto.getMax_weight());
        assertEquals(drone.getBattery_capacity(), droneDto.getBattery_capacity());
        assertEquals(drone.getState(), droneDto.getState());
    }

    @Test
    public void testMapToDrone() {
        // Arrange
        DroneDto droneDto = MockData.mockDroneDto();

        // Act
        Drone drone = DroneMapper.mapToDrone(droneDto);

        // Assert
        assertEquals(droneDto.getId(), drone.getId());
        assertEquals(droneDto.getSerial_number(), drone.getSerial_number());
        assertEquals(droneDto.getModel(), drone.getModel());
        assertEquals(droneDto.getMax_weight(), drone.getMax_weight());
        assertEquals(droneDto.getBattery_capacity(), drone.getBattery_capacity());
        assertEquals(droneDto.getState(), drone.getState());
    }
}
