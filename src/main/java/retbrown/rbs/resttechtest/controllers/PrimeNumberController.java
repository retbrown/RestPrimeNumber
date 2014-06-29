package retbrown.rbs.resttechtest.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import retbrown.rbs.resttechtest.domain.PrimeNumber;
import org.springframework.http.HttpStatus;
import retbrown.rbs.resttechtest.exceptions.InvalidNumberException;
import retbrown.rbs.resttechtest.exceptions.PrimeNumberException;

@RestController
public class PrimeNumberController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrimeNumberController.class);

    @RequestMapping(value = "/primes/{initial}", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PrimeNumber primesAsJson(@PathVariable("initial") String initial, @RequestParam("method") String algorithm) {
        LOGGER.info("json method");
        Integer initialInt;
        try {
            initialInt = Integer.valueOf(initial);
        } catch (NumberFormatException ex) {
            throw new InvalidNumberException();
        }
        return new PrimeNumber(initialInt, calculatePrimes(initialInt, algorithm));
    }

    @RequestMapping(value = "/primes/{initial}", method = RequestMethod.GET, headers = "Accept=application/xml", produces = "application/xml")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PrimeNumber primesAsXml(@PathVariable("initial") String initial, @RequestParam("method") String algorithm) {
        LOGGER.info("xml method");
        Integer initialInt;
        try {
            initialInt = Integer.valueOf(initial);
        } catch (NumberFormatException ex) {
            throw new InvalidNumberException();
        }
        return new PrimeNumber(initialInt, calculatePrimes(initialInt, algorithm));
    }

    private List<Integer> calculatePrimes(Integer initial, String algorithm) {
        switch (algorithm) {
            case "sieve":
                return calculatePrimesSieve(initial);
            case "simple":
                return calculatePrimesSimple(initial);
            default:
                return calculatePrimesSieve(initial);
        }
    }

    private List<Integer> calculatePrimesSieve(Integer initial) {
        if (initial < 2) {
            throw new PrimeNumberException(initial);
        }

        List<Integer> primes = new ArrayList<Integer>();

        boolean[] isPrime = new boolean[initial + 1];
        Arrays.fill(isPrime, Boolean.TRUE);

        for (Integer i = 2; i * i <= initial; i++) {
            if (isPrime[i]) {
                for (Integer j = i; i * j <= initial; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        for (Integer i = 2; i <= initial; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    private List<Integer> calculatePrimesSimple(int initial) {
        if (initial < 2) {
            throw new PrimeNumberException(initial);
        }

        List<Integer> primes = new ArrayList<Integer>();

        for (int i = 2; i<= initial; i++) {
            boolean prime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime) {
                primes.add(i);
            }
        }

        return primes;
    }
}
