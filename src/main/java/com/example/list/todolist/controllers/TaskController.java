package com.example.list.todolist.controllers;


import com.example.list.todolist.model.Task;
import com.example.list.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTask());
    }
    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getAllCompletedTasks() {
        return ResponseEntity.ok(taskService.findAllCompletedTask());
    }
    @GetMapping("/incomplete")
    public ResponseEntity<List<Task>> getAllIncompleteTasks() {
        return ResponseEntity.ok(taskService.findAllInCompleteTask());
    }
    @PostMapping("/addToDo")
    public ResponseEntity<Task> createTask(@RequestBody Task title) {
        return ResponseEntity.ok(taskService.createNewTask(title));
    }
    @PutMapping("/updateToDo/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task title) {
        title.setId(id);
        return ResponseEntity.ok(taskService.updateTask(title));
    }
    @DeleteMapping("/deleteToDo/{id}")
    public ResponseEntity<Boolean> getAllTasks(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/filterDate")
    public ResponseEntity<List<Task>> getFilteredTasks(){
        return ResponseEntity.ok(taskService.filterDate());
    }

    @GetMapping("/filterComplete")
    public ResponseEntity<List<Task>> getCompletedTasks(){
        return ResponseEntity.ok(taskService.filterComplete());
    }
}

