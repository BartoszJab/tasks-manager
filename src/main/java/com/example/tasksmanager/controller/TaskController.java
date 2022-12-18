package com.example.tasksmanager.controller;

import com.example.tasksmanager.dto.SubtaskDto;
import com.example.tasksmanager.model.Subtask;
import com.example.tasksmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/{taskId}/subtasks")
    Subtask addSubtaskToTask(@PathVariable Long taskId, @RequestBody SubtaskDto subtask) {
        return taskService.addSubtaskToTask(taskId, subtask);
    }
}
