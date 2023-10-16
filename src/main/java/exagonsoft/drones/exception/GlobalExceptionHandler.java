package exagonsoft.drones.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MaxWeightExceededException.class)
    public ResponseEntity<ErrorResponse> handleMaxWeightExceededException(MaxWeightExceededException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), "Conflict", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DuplicateSerialNumberException.class)
    public ResponseEntity<ErrorResponse> handleSerialNumberException(DuplicateSerialNumberException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), "Conflict", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MaxSerialNumberCharacters.class)
    public ResponseEntity<ErrorResponse> handleSerialNumberMaxLengthException(MaxSerialNumberCharacters ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), "Conflict", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(StateAllowedValueException.class)
    public ResponseEntity<ErrorResponse> handleStateValueException(StateAllowedValueException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), "Conflict", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ModelAllowedValueException.class)
    public ResponseEntity<ErrorResponse> handleModelValueException(ModelAllowedValueException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), "Conflict", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(LowBatteryException.class)
    public ResponseEntity<ErrorResponse> handleLowBatteryException(LowBatteryException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), "Conflict", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MaxWeightCapacityExceededException.class)
    public ResponseEntity<ErrorResponse> handleMaxWeightCapacityExceededException(MaxWeightCapacityExceededException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), "Conflict", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MedicationInvalidNamePatternException.class)
    public ResponseEntity<ErrorResponse> handleMedicationNamePatternException(MedicationInvalidNamePatternException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), "Conflict", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MedicationCodeInvalidPatternException.class)
    public ResponseEntity<ErrorResponse> handleMedicationCodePatternException(MedicationCodeInvalidPatternException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), "Conflict", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DroneInvalidLoadStateException.class)
    public ResponseEntity<ErrorResponse> handleLoadDroneInvalidStateException(DroneInvalidLoadStateException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), "Conflict", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleOtherExceptions(Exception ex) {

        // *Handle Drone State Exception */
        if (ex.getMessage().contains("RETURNING, DELIVERED,")) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(),
                    "Conflict",
                    "Drone state MistMatch!. (state valid value [IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING])");
            return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
        }
        // *Handle Drone Model Exception */
        if (ex.getMessage().contains("Middleweight, Lightweight,")) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(),
                    "Conflict",
                    "Drone model MistMatch!. (model valid value [Lightweight, Middleweight, Cruiserweight, Heavyweight])");
            return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
        }

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
