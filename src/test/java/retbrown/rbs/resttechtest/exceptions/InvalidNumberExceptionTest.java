package retbrown.rbs.resttechtest.exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

public class InvalidNumberExceptionTest {
    @Test
    public void testMessage() {
        InvalidNumberException invalidNumberException = new InvalidNumberException();
        assertEquals("The returned message is not correct", "initial cannot be null", invalidNumberException.getMessage());
    }
}