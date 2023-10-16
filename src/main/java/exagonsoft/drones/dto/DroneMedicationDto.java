package exagonsoft.drones.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DroneMedicationDto {
    private Long id;
    private Long droneId;
    private Long medicationId;
}
