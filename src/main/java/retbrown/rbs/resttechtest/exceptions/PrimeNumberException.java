package retbrown.rbs.resttechtest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE, reason="Invalid initial")
public class PrimeNumberException extends RuntimeException{

    public PrimeNumberException(Integer initial) {
        super(initial + " is an invalid initial number");
    }
}
