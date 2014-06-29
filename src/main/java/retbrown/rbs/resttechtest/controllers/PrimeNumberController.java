package retbrown.rbs.resttechtest.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import retbrown.rbs.resttechtest.domain.PrimeNumber;
import org.springframework.http.HttpStatus;

@RestController
public class PrimeNumberController {
    private static final Logger logger = LoggerFactory.getLogger(PrimeNumberController.class);


    @RequestMapping(value = "/primes/{initial}", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PrimeNumber primesAsJson(@PathVariable("initial") String initial) {
        logger.info("json method");
        return new PrimeNumber(initial, calculatePrimes(Integer.valueOf(initial)));
    }

    @RequestMapping(value = "/primes/{initial}", method = RequestMethod.GET, headers = "Accept=application/xml", produces = "application/xml")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PrimeNumber primesAsXml(@PathVariable("initial") String initial) {
        logger.info("xml method");
        return new PrimeNumber(initial, calculatePrimes(Integer.valueOf(initial)));
    }

    private List<Integer> calculatePrimes(Integer initial) {
        List<Integer> primes = new ArrayList<Integer>();

        boolean[] isPrime = new boolean[initial + 1];
        Arrays.fill(isPrime, Boolean.TRUE);

        for (Integer i = 2; i*i <= initial; i++) {
            if (isPrime[i]) {
                for (Integer j = i; i*j <= initial; j++) {
                    isPrime[i*j] = false;
                }
            }
        }

        for (Integer i = 2; i <= initial; i++) {
            if (isPrime[i]) primes.add(i);
        }

        return primes;
    }
}
