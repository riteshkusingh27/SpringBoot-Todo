package com.todoapp.todo.services;


import com.todoapp.todo.models.Task;
import com.todoapp.todo.repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TaskRepo taskrepo;

    public TodoService(TaskRepo taskrepo) {
        this.taskrepo = taskrepo;
    }


    public List<Task> getAllTasks() {
        return taskrepo.findAll();
    }

    public void createTask(String title) {

        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskrepo.save(task);             // saving to repository
    }

    public void deleteTask(Long id) {

        taskrepo.deleteById(id);
    }

    public void toogletask(Long id) {

        // find the task by id
        Task task = taskrepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task id "));
        task.setCompleted(!task.isCompleted());
        taskrepo.save(task);
    }
}
