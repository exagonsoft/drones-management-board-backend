package exagonsoft.drones.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medications")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[a-zA-Z0-9_-]*$", message = "Name can only contain letters, numbers, '-', and '_'")
    @Size(max = 255, message = "Name cannot exceed 255 characters")
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "weight", nullable = false)
    private Integer weight;

    @Pattern(regexp = "^[A-Z0-9_]*$", message = "Code can only contain uppercase letters, numbers, and '_'")
    @Size(max = 255, message = "Code cannot exceed 255 characters")
    @Column(name = "code", nullable = false, length = 255)
    private String code;

    @Size(max = 1000, message = "Image URL/path cannot exceed 1000 characters")
    @Column(name = "image_url", nullable = false, length = 1000)
    private String imageUrl;
}

