package exagonsoft.drones.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicationDto {
    private Long id;
    private String name;
    private Integer weight;
    private String code;
    private String imageUrl;
}
