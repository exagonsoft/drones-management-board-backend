package exagonsoft.drones.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    @Test
    public void testHandleMaxWeightExceededException() {
        MaxWeightExceededException ex = new MaxWeightExceededException("Max weight exceeded");
        ResponseEntity<ErrorResponse> responseEntity = globalExceptionHandler.handleMaxWeightExceededException(ex);
        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
        assertEquals("Conflict", responseEntity.getBody().getError());
        assertEquals("Max weight exceeded", responseEntity.getBody().getMessage());
    }

    @Test
    public void testHandleDuplicateSerialNumberException() {
        MaxWeightExceededException ex = new MaxWeightExceededException("Max weight exceeded");
        ResponseEntity<ErrorResponse> responseEntity = globalExceptionHandler.handleMaxWeightExceededException(ex);
        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
        assertEquals("Conflict", responseEntity.getBody().getError());
        assertEquals("Max weight exceeded", responseEntity.getBody().getMessage());
    }

    @Test
    public void testHandleMaxSerialNumberCharacters() {
        MaxWeightExceededException ex = new MaxWeightExceededException("Max weight exceeded");
        ResponseEntity<ErrorResponse> responseEntity = globalExceptionHandler.handleMaxWeightExceededException(ex);
        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
        assertEquals("Conflict", responseEntity.getBody().getError());
        assertEquals("Max weight exceeded", responseEntity.getBody().getMessage());
    }

    @Test
    public void testHandlerStateAllowedValueException() {
        MaxWeightExceededException ex = new MaxWeightExceededException("Max weight exceeded");
        ResponseEntity<ErrorResponse> responseEntity = globalExceptionHandler.handleMaxWeightExceededException(ex);
        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
        assertEquals("Conflict", responseEntity.getBody().getError());
        assertEquals("Max weight exceeded", responseEntity.getBody().getMessage());
    }

    @Test
    public void testHandlerLowBatteryException() {
        MaxWeightExceededException ex = new MaxWeightExceededException("Max weight exceeded");
        ResponseEntity<ErrorResponse> responseEntity = globalExceptionHandler.handleMaxWeightExceededException(ex);
        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
        assertEquals("Conflict", responseEntity.getBody().getError());
        assertEquals("Max weight exceeded", responseEntity.getBody().getMessage());
    }

    @Test
    public void testHandlerMaxWeightCapacityExceededException() {
        MaxWeightExceededException ex = new MaxWeightExceededException("Max weight exceeded");
        ResponseEntity<ErrorResponse> responseEntity = globalExceptionHandler.handleMaxWeightExceededException(ex);
        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
        assertEquals("Conflict", responseEntity.getBody().getError());
        assertEquals("Max weight exceeded", responseEntity.getBody().getMessage());
    }

    @Test
    public void testHandlerMedicationInvalidNamePatternException() {
        MaxWeightExceededException ex = new MaxWeightExceededException("Max weight exceeded");
        ResponseEntity<ErrorResponse> responseEntity = globalExceptionHandler.handleMaxWeightExceededException(ex);
        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
        assertEquals("Conflict", responseEntity.getBody().getError());
        assertEquals("Max weight exceeded", responseEntity.getBody().getMessage());
    }

    @Test
    public void testHandlerMedicationCodeInvalidPatternException() {
        MaxWeightExceededException ex = new MaxWeightExceededException("Max weight exceeded");
        ResponseEntity<ErrorResponse> responseEntity = globalExceptionHandler.handleMaxWeightExceededException(ex);
        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
        assertEquals("Conflict", responseEntity.getBody().getError());
        assertEquals("Max weight exceeded", responseEntity.getBody().getMessage());
    }

    @Test
    public void testHandlerDroneInvalidLoadStateException() {
        MaxWeightExceededException ex = new MaxWeightExceededException("Max weight exceeded");
        ResponseEntity<ErrorResponse> responseEntity = globalExceptionHandler.handleMaxWeightExceededException(ex);
        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
        assertEquals("Conflict", responseEntity.getBody().getError());
        assertEquals("Max weight exceeded", responseEntity.getBody().getMessage());
    }

    @Test
    public void testHandlerModelAllowedValueException() {
        MaxWeightExceededException ex = new MaxWeightExceededException("Max weight exceeded");
        ResponseEntity<ErrorResponse> responseEntity = globalExceptionHandler.handleMaxWeightExceededException(ex);
        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
        assertEquals("Conflict", responseEntity.getBody().getError());
        assertEquals("Max weight exceeded", responseEntity.getBody().getMessage());
    }

    @Test
    public void testHandleOtherExceptions() {
        Exception ex = new Exception("Some error message");
        ResponseEntity<ErrorResponse> responseEntity = globalExceptionHandler.handleOtherExceptions(ex);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("Internal Server Error", responseEntity.getBody().getError());
        assertEquals("Some error message", responseEntity.getBody().getMessage());
    }

    // Add more tests for different exception scenarios as needed
}

