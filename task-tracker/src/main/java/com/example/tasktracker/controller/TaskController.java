package com.example.tasktracker.controller;

import com.example.tasktracker.model.Task;
import com.example.tasktracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class exposes our backend as a REST API.
 * Every method here corresponds to one URL + HTTP method combo
 * that the frontend JavaScript will call using fetch().
 *
 * @RestController = this class handles HTTP requests and returns JSON
 *                    (instead of returning an HTML page, like older Spring MVC did).
 * @RequestMapping("/api/tasks") = every method's URL starts with this prefix.
 */
@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*") // allows the frontend to call this API even from a different origin/port
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // GET /api/tasks -> list all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // GET /api/tasks/5 -> get one task by id
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/tasks -> create a new task (data comes from the request body as JSON)
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    // PUT /api/tasks/5 -> update an existing task
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        try {
            return ResponseEntity.ok(taskService.updateTask(id, task));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/tasks/5 -> delete a task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
