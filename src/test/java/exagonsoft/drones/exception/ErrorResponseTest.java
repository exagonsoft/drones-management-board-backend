package exagonsoft.drones.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorResponseTest {

    @Test
    void testErrorResponseGettersAndSetters() {
        int status = 404;
        String error = "Not Found";
        String message = "Resource not found.";

        ErrorResponse errorResponse = new ErrorResponse(status, error, message);

        // Test getters
        assertEquals(status, errorResponse.getStatus());
        assertEquals(error, errorResponse.getError());
        assertEquals(message, errorResponse.getMessage());

        // Test setters
        int newStatus = 500;
        String newError = "Internal Server Error";
        String newMessage = "Internal server error occurred.";

        errorResponse.setStatus(newStatus);
        errorResponse.setError(newError);
        errorResponse.setMessage(newMessage);

        assertEquals(newStatus, errorResponse.getStatus());
        assertEquals(newError, errorResponse.getError());
        assertEquals(newMessage, errorResponse.getMessage());
    }
}
