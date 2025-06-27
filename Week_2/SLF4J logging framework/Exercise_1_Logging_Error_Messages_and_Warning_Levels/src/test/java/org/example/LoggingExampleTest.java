package org.example;

import org.junit.Test;

public class LoggingExampleTest {

    @Test
    public void testLogMessages() {
        Main example = new Main();
        example.logMessages();
        // Since logging doesn't return output, this test just ensures no exceptions occur
    }
}
