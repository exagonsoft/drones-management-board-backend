package exagonsoft.drones.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "drones")
public class Drone {

    public enum ModelType {
        Lightweight,
        Middleweight,
        Cruiserweight,
        Heavyweight
    }

    public enum StateType {
        IDLE,
        LOADING,
        LOADED,
        DELIVERING,
        DELIVERED,
        RETURNING
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_number", nullable = false, unique = true, length = 100)
    private String serial_number;

    @Column(name = "model", nullable = false)
    @Enumerated(EnumType.STRING)
    private ModelType model;

    @Column(name = "max_weight", nullable = false)
    @Max(value = 500, message = "Maximum weight cannot exceed 500gr")
    private Integer max_weight;

    @Column(name = "battery_capacity", nullable = false)
    @Max(value = 100, message = "Battery capacity cannot exceed 100%")
    private Integer battery_capacity;

    @Column(name = "state", nullable = false)
    @Enumerated(EnumType.STRING)
    private StateType state;
}
