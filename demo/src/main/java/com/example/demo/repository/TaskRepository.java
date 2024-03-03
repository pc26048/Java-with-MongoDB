package com.example.demo.repository;

import com.example.demo.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface TaskRepository extends MongoRepository<Task,String> {



    List<Task> findBySeverity(int severity);


    @Query("{ assignee: ?0 }")
    List<Task> getTasksByAssignee(String assignee);
}
