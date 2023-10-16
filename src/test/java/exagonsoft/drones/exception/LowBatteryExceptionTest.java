package exagonsoft.drones.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LowBatteryExceptionTest {

    @Test
    void testLowBatteryException() {
        String errorMessage = "Low battery level detected.";

        LowBatteryException lowBatteryException = new LowBatteryException(errorMessage);

        // Test if the exception message is set correctly
        assertEquals(errorMessage, lowBatteryException.getMessage());
    }
}
