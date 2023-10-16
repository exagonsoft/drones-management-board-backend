package exagonsoft.drones.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedicationCodeInvalidPatternExceptionTest {

    @Test
    void testMedicationCodeInvalidPatternException() {
        String errorMessage = "Invalid medication code pattern.";

        MedicationCodeInvalidPatternException exception = new MedicationCodeInvalidPatternException(errorMessage);

        // Test if the exception message is set correctly
        assertEquals(errorMessage, exception.getMessage());
    }
}
