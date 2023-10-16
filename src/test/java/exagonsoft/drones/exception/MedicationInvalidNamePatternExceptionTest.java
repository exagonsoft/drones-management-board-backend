package exagonsoft.drones.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedicationInvalidNamePatternExceptionTest {

    @Test
    void testMedicationInvalidNamePatternException() {
        String errorMessage = "Invalid medication name pattern.";

        MedicationInvalidNamePatternException exception = new MedicationInvalidNamePatternException(errorMessage);

        // Test if the exception message is set correctly
        assertEquals(errorMessage, exception.getMessage());
    }
}

