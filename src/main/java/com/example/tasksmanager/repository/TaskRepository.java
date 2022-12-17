package com.example.tasksmanager.repository;

import com.example.tasksmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findByIdAndGroupId(Long id, Long groupId);
}
