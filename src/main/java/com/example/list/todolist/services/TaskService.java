package com.example.list.todolist.services;


import com.example.list.todolist.model.Task;
import com.example.list.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createNewTask(Task title) {
        return taskRepository.save(title);
    }

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public Task findTaskById(Long id) {
        return taskRepository.getById(id);
    }

    public List<Task> findAllCompletedTask() {
        return taskRepository.findByCompletedTrue();
    }

    public List<Task> findAllInCompleteTask() {
        return taskRepository.findByCompletedFalse();
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(Task title) {
        return taskRepository.save(title);
    }

    public List<Task> filterDate(){
        return taskRepository.findTasksByDueDate();
    }

    public List<Task> filterComplete(){
        return taskRepository.findTasksByComplete();
    }

}

