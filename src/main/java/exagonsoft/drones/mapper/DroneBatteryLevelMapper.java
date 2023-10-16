package exagonsoft.drones.mapper;

import exagonsoft.drones.dto.BatteryLevelDto;

public class DroneBatteryLevelMapper {
    public static BatteryLevelDto mapToBatteryLevelDto(int batteryLevel){
        return new BatteryLevelDto(
            batteryLevel
        );
    }
}
