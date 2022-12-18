package com.example.tasksmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
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

    public Task(Long groupId, String name, String description, LocalDateTime deadlineTime, boolean isCompleted) {
        this.groupId = groupId;
        this.name = name;
        this.description = description;
        this.deadlineTime = deadlineTime;
        this.isCompleted = isCompleted;
    }
}
