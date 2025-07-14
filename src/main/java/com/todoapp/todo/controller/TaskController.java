package com.todoapp.todo.controller;

import com.todoapp.todo.models.Task;
import com.todoapp.todo.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class TaskController {


    private final TodoService todoService;

    public TaskController(TodoService todoService) {
        this.todoService = todoService;
    }
   @GetMapping()
    public String getTask (Model model){
        List<Task> tasks  = todoService.getAllTasks();
        model.addAttribute("tasks" , tasks); // passing data via tasks into the view
        return "tasks";    // looks for tasks.html inside the resources

    }

    @PostMapping()
    public String createTask (@RequestParam String title){

        todoService.createTask(title);
        return "redirect:/"   ; // refresh the tasks page

    }
    @GetMapping("/{id}/delete")
    public String deleteTask (@PathVariable Long id){
         todoService.deleteTask(id);
        return "redirect:/";    // looks for tasks.html inside the resources

    }

    @GetMapping("/{id}/toogle")
    public String toogletask (@PathVariable Long id){
        todoService.toogletask(id);
        return "redirect:/";    // looks for tasks.html inside the resources

    }
}
