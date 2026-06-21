package com.example.tasktracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the entry point of the whole application.
 * Running this `main` method starts an embedded web server (Tomcat)
 * and wires up everything Spring needs - no separate server install required.
 */
@SpringBootApplication
public class TaskTrackerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskTrackerApplication.class, args);
    }
}
