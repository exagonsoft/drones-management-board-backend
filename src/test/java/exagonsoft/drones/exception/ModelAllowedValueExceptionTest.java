package exagonsoft.drones.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ModelAllowedValueExceptionTest {

    @Test
    void testModelAllowedValueException() {
        String errorMessage = "Invalid model value.";

        ModelAllowedValueException exception = new ModelAllowedValueException(errorMessage);

        // Test if the exception message is set correctly
        assertEquals(errorMessage, exception.getMessage());
    }
}
