package com.example.tasktracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * This class represents one row in the "task" database table.
 * @Entity tells Spring/JPA: "treat this Java class as a database table."
 * You don't write any SQL to create the table - JPA generates it from this class automatically.
 */
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-incrementing ID, like AUTO_INCREMENT in SQL
    private Long id;

    private String title;

    private String description;

    private String priority; // "LOW", "MEDIUM", "HIGH"

    private String status; // "TODO", "IN_PROGRESS", "DONE"

    // --- Constructors ---

    public Task() {
        // JPA requires a no-argument constructor - it uses this internally
        // when loading rows from the database.
    }

    public Task(String title, String description, String priority, String status) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    // --- Getters and setters ---
    // Spring uses these to convert between Java objects and JSON automatically.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
