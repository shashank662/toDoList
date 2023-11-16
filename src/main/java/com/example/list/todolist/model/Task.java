package com.example.list.todolist.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // this is the primary key which will be auto generated
    private Long id;

    private String title;
    private String task;

    private LocalDate due;
    private boolean completed;

    public Task() {
    }

    public Task(String title, String task, LocalDate due, boolean completed) {
        this.title = title;
        this.task = task;
        this.due = due;
        this.completed = completed;
    }
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

    public LocalDate getDue() {
        return due;
    }

    public void setDue(LocalDate due) {
        this.due = due;
    }

    public String getTask() {
        return task;
    }
    public void setTask(String task) {
        this.task = task;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


}


