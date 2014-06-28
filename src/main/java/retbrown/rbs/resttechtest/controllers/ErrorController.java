package retbrown.rbs.resttechtest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import retbrown.rbs.resttechtest.domain.PrimeNumber;

@RestController
public class ErrorController {
    @RequestMapping(value = "/error", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String returnNotFound() {
        return "Not found";
    }
}
