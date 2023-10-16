package exagonsoft.drones.dto;

import exagonsoft.drones.entity.Drone.ModelType;
import exagonsoft.drones.entity.Drone.StateType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DroneDto {
    private Long id;
    private String serial_number;
    private ModelType model;
    private Integer max_weight;
    private Integer battery_capacity;
    private StateType state;
}
