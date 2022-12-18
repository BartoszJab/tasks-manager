package com.example.tasksmanager.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TaskDto {

    private String name;
    private String description;
    private LocalDateTime deadlineTime;
}
