package retbrown.restprimenum.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Null initial")
public class InvalidNumberException extends RuntimeException{

        public InvalidNumberException() {
            super("initial cannot be null");
        }
}
