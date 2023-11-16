package com.example.list.todolist.repository;

import com.example.list.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    public Task findByTask(String title);
    public List<Task> findByCompletedTrue();
    public List<Task> findByCompletedFalse();
//    public List<Task> findAll();
    public Task getById(Long id);

    public void deleteById(Long id);

    @Query("SELECT t FROM Task t ORDER BY t.due ASC")
    public List<Task> findTasksByDueDate();
    @Query("SELECT t FROM Task t WHERE t.completed = true")
    public List<Task> findTasksByComplete();

}

