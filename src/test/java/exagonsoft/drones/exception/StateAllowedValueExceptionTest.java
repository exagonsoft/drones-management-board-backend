package exagonsoft.drones.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StateAllowedValueExceptionTest {

    @Test
    void testStateAllowedValueException() {
        String errorMessage = "Invalid state value.";

        StateAllowedValueException exception = new StateAllowedValueException(errorMessage);

        // Test if the exception message is set correctly
        assertEquals(errorMessage, exception.getMessage());
    }
}

