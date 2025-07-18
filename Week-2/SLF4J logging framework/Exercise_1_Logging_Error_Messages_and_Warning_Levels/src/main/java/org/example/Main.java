package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public void logMessages() {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
    }

    public static void main(String[] args) {
        Main example = new Main();
        example.logMessages();
    }
}
