package com.todoapp.todo.repository;

import com.todoapp.todo.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task,Long> {

}
