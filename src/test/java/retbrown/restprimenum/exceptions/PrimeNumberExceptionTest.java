package retbrown.restprimenum.exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeNumberExceptionTest {
    @Test
    public void testNegativeInteger(){
        PrimeNumberException primeNumberException = new PrimeNumberException(-10);

        assertEquals("The returned message is not correct", "-10 is an invalid initial number", primeNumberException.getMessage());
    }

    @Test
    public void testZero() {
        PrimeNumberException primeNumberException = new PrimeNumberException(0);

        assertEquals("The returned message is not correct", "0 is an invalid initial number", primeNumberException.getMessage());
    }

    @Test
    public void testSmallInteger() {
        PrimeNumberException primeNumberException = new PrimeNumberException(10);

        assertEquals("The returned message is not correct", "10 is an invalid initial number", primeNumberException.getMessage());
    }

    @Test
    public void testLargeInteger() {
        PrimeNumberException primeNumberException = new PrimeNumberException(1000);

        assertEquals("The returned message is not correct", "1000 is an invalid initial number", primeNumberException.getMessage());
    }

    @Test
    public void testVeryLargeInteger() {
        PrimeNumberException primeNumberException = new PrimeNumberException(1000000000);

        assertEquals("The returned message is not correct", "1000000000 is an invalid initial number", primeNumberException.getMessage());
    }
}