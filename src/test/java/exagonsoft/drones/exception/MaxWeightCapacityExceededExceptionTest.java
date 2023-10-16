package exagonsoft.drones.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxWeightCapacityExceededExceptionTest {

    @Test
    void testMaxWeightCapacityExceededException() {
        String errorMessage = "Weight capacity exceeded.";

        MaxWeightCapacityExceededException exception = new MaxWeightCapacityExceededException(errorMessage);

        // Test if the exception message is set correctly
        assertEquals(errorMessage, exception.getMessage());
    }
}
