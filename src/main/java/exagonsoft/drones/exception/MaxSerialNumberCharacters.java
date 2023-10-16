package exagonsoft.drones.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class MaxSerialNumberCharacters extends RuntimeException{
    public MaxSerialNumberCharacters(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
