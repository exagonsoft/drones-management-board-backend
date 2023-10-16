package exagonsoft.drones.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ResourceNotFoundExceptionTest {

    @Test
    void testResourceNotFoundException() {
        String errorMessage = "Resource not found.";

        ResourceNotFoundException exception = new ResourceNotFoundException(errorMessage);

        // Test if the exception message is set correctly
        assertEquals(errorMessage, exception.getMessage());
    }
}
