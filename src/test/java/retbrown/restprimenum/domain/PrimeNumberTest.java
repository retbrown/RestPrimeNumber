package retbrown.restprimenum.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PrimeNumberTest {

    @Test
    public void testDefaultEmptyConstructor() {
        PrimeNumber primeNumber = new PrimeNumber();

        assertEquals("The default initial is not correct", 0, (int) primeNumber.getInitial());
    }

    @Test
    public void testNullPrimes() {
        PrimeNumber primeNumber = new PrimeNumber(1, null);

        assertEquals("The intial value is not correct", 1, (int) primeNumber.getInitial());
        assertNull("The primes list is not null", primeNumber.getPrimes());
    }

    @Test
    public void testZeroPrimes() {
        PrimeNumber primeNumber = new PrimeNumber(1, new ArrayList<Integer>());

        assertEquals("The initial value is not correct", 1, (int) primeNumber.getInitial());
        assertEquals("The primes list is too big", 0, primeNumber.getPrimes().size());
    }

    @Test
    public void testFullConstructor(){
        PrimeNumber primeNumber = new PrimeNumber(3, Arrays.asList(2,3));

        assertEquals("The inital value is not correct", 3, (int) primeNumber.getInitial());
        assertEquals("The primes list is not the correct size", 2, primeNumber.getPrimes().size());
        assertEquals("The primes list does not contain the correct items", Arrays.asList(2,3), primeNumber.getPrimes());
    }

    @Test
    public void testGetIntial() {
        PrimeNumber primeNumber = new PrimeNumber(3, Arrays.asList(2,3));

        assertEquals("The initial has been returned wrongly", 3, (int) primeNumber.getInitial());
    }

    @Test
    public void testGetPrimes() {
        PrimeNumber primeNumber = new PrimeNumber(3, Arrays.asList(2,3));

        assertEquals("The primes list does not contain the correct items", Arrays.asList(2,3), primeNumber.getPrimes());
    }

}