package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testVariousAssertions() {
        // Assert that two numbers are equal
        assertEquals("Sum of 7 and 8 should be 15", 15, 7 + 8);

        // Assert that a condition is true
        assertTrue( "10 is greater than 5",10 > 5);

        // Assert that a condition is false
        assertFalse("3 is not greater than 7", 3 > 7);

        // Assert that an object reference is null
        String str = null;
        assertNull("String reference should be null", str);

        // Assert that an object reference is NOT null
        Object obj = new Object();
        assertNotNull("Object should not be null", obj);

        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals("Arrays should be equal", expected, actual);
    }
}

