package org.example;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Main calculator;

    // Setup method - runs before each test
    @Before
    public void setUp() {
        // Arrange part: Initialize objects required for tests
        calculator = new Main();
    }

    // Teardown method - runs after each test
    @After
    public void tearDown() {
        // Cleanup code if needed
        calculator = null;
    }

    @Test
    public void testAdd() {
        // Act: Perform the action
        int result = calculator.add(5, 3);

        // Assert: Verify the outcome
        assertEquals(8, result);
    }

    @Test
    public void testSubtract() {
        // Act
        int result = calculator.subtract(10, 4);

        // Assert
        assertEquals(6, result);
    }
}

