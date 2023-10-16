package exagonsoft.drones.mapper;

import exagonsoft.drones.dto.DroneDto;
import exagonsoft.drones.entity.Drone;

public class DroneMapper {
    public static DroneDto mapToDroneDto(Drone drone) {
        return new DroneDto(
                drone.getId(),
                drone.getSerial_number(),
                drone.getModel(),
                drone.getMax_weight(),
                drone.getBattery_capacity(),
                drone.getState());
    }

    public static Drone mapToDrone(DroneDto droneDto) {
        return new Drone(
                droneDto.getId(),
                droneDto.getSerial_number(),
                droneDto.getModel(),
                droneDto.getMax_weight(),
                droneDto.getBattery_capacity(),
                droneDto.getState());
    }
}
