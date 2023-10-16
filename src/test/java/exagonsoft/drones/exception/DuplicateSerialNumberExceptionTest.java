package exagonsoft.drones.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DuplicateSerialNumberExceptionTest {

    @Test
    void testExceptionMessage() {
        String errorMessage = "Duplicate Serial Number Exception";
        DuplicateSerialNumberException exception = new DuplicateSerialNumberException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }
}
