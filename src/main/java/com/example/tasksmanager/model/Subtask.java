package com.example.tasksmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subtasks")
@Getter
@Setter
@NoArgsConstructor
public class Subtask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long taskId;
    private String content;
    private boolean isDone;

    public Subtask(Long taskId, String content, boolean isDone) {
        this.taskId = taskId;
        this.content = content;
        this.isDone = isDone;
    }
}
