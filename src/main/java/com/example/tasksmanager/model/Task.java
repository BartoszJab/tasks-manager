package com.example.tasksmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long groupId;
    private String name;
    private String description;
    private LocalDateTime deadlineTime;
    private boolean isCompleted;

    @OneToMany
    @JoinColumn(name = "task_id")
    private List<Subtask> subtasks;
}
