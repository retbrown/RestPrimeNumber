package retbrown.rbs.resttechtest.controllers;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import retbrown.rbs.resttechtest.domain.PrimeNumber;
import retbrown.rbs.resttechtest.exceptions.InvalidNumberException;
import retbrown.rbs.resttechtest.exceptions.PrimeNumberException;

import java.util.Arrays;

public class PrimeNumberControllerTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testJSONResultSieve() {
        PrimeNumberController primeNumberController = new PrimeNumberController();
        String initial = "52";

        PrimeNumber primeNumber = primeNumberController.primesAsJson(initial,"sieve");
        assertNotNull("The returned value is null", primeNumber);
        assertEquals("The returned initial value does not equal the passed initial", Integer.valueOf(initial), primeNumber.getInitial());
        assertEquals("The returned primes list is not the correct size", 15, primeNumber.getPrimes().size());
        assertEquals("The returned list of primes is not correct", Arrays.asList(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47), primeNumber.getPrimes());
    }

    @Test
    public void testXMLResultSieve() {
        PrimeNumberController primeNumberController = new PrimeNumberController();
        String initial = "52";

        PrimeNumber primeNumber = primeNumberController.primesAsXml(initial,"sieve");
        assertNotNull("The returned value is null", primeNumber);
        assertEquals("The returned initial value does not equal the passed initial", Integer.valueOf(initial), primeNumber.getInitial());
        assertEquals("The returned primes list is not the correct size", 15, primeNumber.getPrimes().size());
        assertEquals("The returned list of primes is not correct", Arrays.asList(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47), primeNumber.getPrimes());
    }

    @Test
    public void testJSONResultDefault() {
        PrimeNumberController primeNumberController = new PrimeNumberController();
        String initial = "52";

        PrimeNumber primeNumber = primeNumberController.primesAsJson(initial,"");
        assertNotNull("The returned value is null", primeNumber);
        assertEquals("The returned initial value does not equal the passed initial", Integer.valueOf(initial), primeNumber.getInitial());
        assertEquals("The returned primes list is not the correct size", 15, primeNumber.getPrimes().size());
        assertEquals("The returned list of primes is not correct", Arrays.asList(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47), primeNumber.getPrimes());
    }

    @Test
    public void testXMLResultDefault() {
        PrimeNumberController primeNumberController = new PrimeNumberController();
        String initial = "52";

        PrimeNumber primeNumber = primeNumberController.primesAsXml(initial,"");
        assertNotNull("The returned value is null", primeNumber);
        assertEquals("The returned initial value does not equal the passed initial", Integer.valueOf(initial), primeNumber.getInitial());
        assertEquals("The returned primes list is not the correct size", 15, primeNumber.getPrimes().size());
        assertEquals("The returned list of primes is not correct", Arrays.asList(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47), primeNumber.getPrimes());
    }

    @Test
    public void testJSONResultSimple() {
        PrimeNumberController primeNumberController = new PrimeNumberController();
        String initial = "52";

        PrimeNumber primeNumber = primeNumberController.primesAsJson(initial,"simple");
        assertNotNull("The returned value is null", primeNumber);
        assertEquals("The returned initial value does not equal the passed initial", Integer.valueOf(initial), primeNumber.getInitial());
        assertEquals("The returned primes list is not the correct size", 15, primeNumber.getPrimes().size());
        assertEquals("The returned list of primes is not correct", Arrays.asList(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47), primeNumber.getPrimes());
    }

    @Test
    public void testXMLResultSimple() {
        PrimeNumberController primeNumberController = new PrimeNumberController();
        String initial = "52";

        PrimeNumber primeNumber = primeNumberController.primesAsXml(initial,"simple");
        assertNotNull("The returned value is null", primeNumber);
        assertEquals("The returned initial value does not equal the passed initial", Integer.valueOf(initial), primeNumber.getInitial());
        assertEquals("The returned primes list is not the correct size", 15, primeNumber.getPrimes().size());
        assertEquals("The returned list of primes is not correct", Arrays.asList(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47), primeNumber.getPrimes());
    }

    @Test
    public void testJSONInvalidCharacter() {
        thrown.expect(InvalidNumberException.class);
        thrown.expectMessage(equalTo("initial cannot be null"));

        PrimeNumberController primeNumberController = new PrimeNumberController();
        String initial = ".";

        PrimeNumber primeNumber = primeNumberController.primesAsJson(initial, "sieve");
        fail("The test should have thrown an exception by now there is something wrong");
    }

    @Test
    public void testXMLInvalidCharacter() {
        thrown.expect(InvalidNumberException.class);
        thrown.expectMessage(equalTo("initial cannot be null"));

        PrimeNumberController primeNumberController = new PrimeNumberController();
        String initial = ".";

        PrimeNumber primeNumber = primeNumberController.primesAsXml(initial, "sieve");
        fail("The test should have thrown an exception by now there is something wrong");
    }

    @Test
    public void testJSONNegativeNumber() {
        thrown.expect(PrimeNumberException.class);
        thrown.expectMessage(equalTo("-100 is an invalid initial number"));

        PrimeNumberController primeNumberController = new PrimeNumberController();
        String initial = "-100";

        PrimeNumber primeNumber = primeNumberController.primesAsJson(initial,"sieve");
        fail("The test should have thrown an exception by now there is something wrong");
    }

    @Test
    public void testXMLNegativeNumber() {
        thrown.expect(PrimeNumberException.class);
        thrown.expectMessage(equalTo("-3 is an invalid initial number"));

        PrimeNumberController primeNumberController = new PrimeNumberController();
        String initial = "-3";

        PrimeNumber primeNumber = primeNumberController.primesAsXml(initial,"sieve");
        fail("The test should have thrown an exception by now there is something wrong");
    }

    @Test
    public void testJSONNegativeNumberSimple() {
        thrown.expect(PrimeNumberException.class);
        thrown.expectMessage(equalTo("-100 is an invalid initial number"));

        PrimeNumberController primeNumberController = new PrimeNumberController();
        String initial = "-100";

        PrimeNumber primeNumber = primeNumberController.primesAsJson(initial,"simple");
        fail("The test should have thrown an exception by now there is something wrong");
    }

    @Test
    public void testXMLNegativeNumberSimple() {
        thrown.expect(PrimeNumberException.class);
        thrown.expectMessage(equalTo("-3 is an invalid initial number"));

        PrimeNumberController primeNumberController = new PrimeNumberController();
        String initial = "-3";

        PrimeNumber primeNumber = primeNumberController.primesAsXml(initial,"simple");
        fail("The test should have thrown an exception by now there is something wrong");
    }
}