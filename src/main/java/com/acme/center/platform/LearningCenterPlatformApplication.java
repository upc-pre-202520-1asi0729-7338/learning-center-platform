package com.acme.center.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Learning Center Platform.
 * This is the entry point for the Spring Boot application.
 */
@SpringBootApplication
public class LearningCenterPlatformApplication {

    /**
     * The main method that starts the Spring Boot application.
     *
     * @param args command line arguments passed to the application
     */
    static void main(String[] args) {
        SpringApplication.run(LearningCenterPlatformApplication.class, args);
    }

}
