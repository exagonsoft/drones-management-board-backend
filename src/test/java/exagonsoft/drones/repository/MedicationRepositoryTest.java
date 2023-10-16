package exagonsoft.drones.repository;

import exagonsoft.drones.entity.Medication;
import exagonsoft.drones.mock.MockData;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class MedicationRepositoryTest {

    @Autowired
    private MedicationRepository medicationRepository;

    @Test
    void testSaveMedication() {
        // Create a sample Medication object
        Medication medication = MockData.mockMedications();
        medication.setName("Sample Medication");
        medication.setWeight(10);
        medication.setCode("MED123");
        medication.setImageUrl("sample-url");
        
        // Save the Medication object to the repository
        Medication savedMedication = medicationRepository.save(medication);

        // Retrieve the saved Medication object from the repository
        Medication retrievedMedication = medicationRepository.findById(savedMedication.getId()).orElse(null);

        // Assert that the retrieved Medication object is not null and has the correct attributes
        assertNotNull(retrievedMedication);
        assertEquals("Sample Medication", retrievedMedication.getName());
        assertEquals(10, retrievedMedication.getWeight());
        assertEquals("MED123", retrievedMedication.getCode());
        assertEquals("sample-url", retrievedMedication.getImageUrl());
    }
}
