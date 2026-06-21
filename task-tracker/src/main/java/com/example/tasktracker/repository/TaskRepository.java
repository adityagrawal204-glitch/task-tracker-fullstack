package com.example.tasktracker.repository;

import com.example.tasktracker.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface gives us save(), findAll(), findById(), deleteById(), etc.
 * for FREE - we don't write any implementation or SQL.
 * Spring Data JPA generates the implementation behind the scenes at startup.
 *
 * <Task, Long> means: this repository manages Task entities, whose ID type is Long.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Empty on purpose - JpaRepository already provides everything we need
    // for this simple project. Later you'll learn to add custom query methods here,
    // e.g. List<Task> findByStatus(String status);
}
