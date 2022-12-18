package com.example.tasksmanager.repository;

import com.example.tasksmanager.model.Subtask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubtaskRepository extends JpaRepository<Subtask, Long> {
}
