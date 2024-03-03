package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class TaskService {



    @Autowired
    private TaskRepository repository;

    public Task addTask(Task task){
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(task);
    }

    public List<Task> findAllTask(){
        return repository.findAll();
    }

    public Task getTaskByTaskId(String taskId){
        return repository.findById(taskId).get();
    }

    public List<Task> getTaskBySeverity(int severity){

        return repository.findBySeverity(severity);

    }
    public List<Task> getTaskByAssignee(String assignee){

        return repository. getTasksByAssignee(assignee);

    }


    public Task updateTask(Task task){

        Task existingTask=repository.findById(task.getTaskId()).get();
        existingTask.setDescription(task.getDescription());
        existingTask.setAssignee(task.getAssignee());
        existingTask.setSeverity(task.getSeverity());
        existingTask.setStoryPoint(task.getStoryPoint());

        return repository.save(existingTask);
    }

    public String deleteTask(String taskId){
        repository.deleteById(taskId);
        return taskId+"task deleted";
    }





}
