package com.example.tasksmanager.repository;

import com.example.tasksmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findByIdAndGroupId(Long id, Long groupId);

    List<Task> findByGroupId(Long groupId);
}
