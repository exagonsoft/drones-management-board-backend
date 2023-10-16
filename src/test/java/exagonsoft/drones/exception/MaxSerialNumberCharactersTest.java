package exagonsoft.drones.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSerialNumberCharactersTest {

    @Test
    void testMaxSerialNumberCharactersException() {
        String errorMessage = "Serial number exceeds maximum length.";

        MaxSerialNumberCharacters exception = new MaxSerialNumberCharacters(errorMessage);

        // Test if the exception message is set correctly
        assertEquals(errorMessage, exception.getMessage());
    }
}
