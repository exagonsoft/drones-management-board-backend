package exagonsoft.drones.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DroneInvalidLoadStateExceptionTest {

    @Test
    void testExceptionMessage() {
        String errorMessage = "Invalid Load State";
        DroneInvalidLoadStateException exception = new DroneInvalidLoadStateException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }
}
