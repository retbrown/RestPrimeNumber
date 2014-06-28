package retbrown.rbs.resttechtest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import retbrown.rbs.resttechtest.domain.PrimeNumber;
import org.springframework.http.HttpStatus;

@RestController
public class PrimeNumberController {

    @RequestMapping(value = "/primes/{initial}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PrimeNumber primesAsJson(@PathVariable("initial") String initial) {
        return new PrimeNumber(initial, calculatePrimes(Integer.valueOf(initial)));
    }

    @RequestMapping(value = "/primes/{initial}", method = RequestMethod.GET, produces = "application/xml")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PrimeNumber primesAsXml(@PathVariable("initial") String initial) {
        return new PrimeNumber(initial, calculatePrimes(Integer.valueOf(initial)));
    }

    private List<Integer> calculatePrimes(int intial) {
        return null;
    }
}
