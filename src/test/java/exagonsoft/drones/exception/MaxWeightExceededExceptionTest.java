package exagonsoft.drones.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxWeightExceededExceptionTest {

    @Test
    void testMaxWeightExceededException() {
        String errorMessage = "Weight exceeded maximum allowed value.";

        MaxWeightExceededException exception = new MaxWeightExceededException(errorMessage);

        // Test if the exception message is set correctly
        assertEquals(errorMessage, exception.getMessage());
    }
}
