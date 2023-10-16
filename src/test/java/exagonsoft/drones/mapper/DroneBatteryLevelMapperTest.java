package exagonsoft.drones.mapper;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import exagonsoft.drones.dto.BatteryLevelDto;

public class DroneBatteryLevelMapperTest {

    @Test
    public void testMapToBatteryLevelDto() {
        // Arrange
        int batteryLevel = 50;

        // Act
        BatteryLevelDto batteryLevelDto = DroneBatteryLevelMapper.mapToBatteryLevelDto(batteryLevel);

        // Assert
        assertEquals(batteryLevel, batteryLevelDto.getBatteryLevel());
    }
}
