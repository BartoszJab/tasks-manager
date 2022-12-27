package com.example.tasksmanager.controller;

import com.example.tasksmanager.dto.SubtaskDto;
import com.example.tasksmanager.dto.TaskDto;
import com.example.tasksmanager.model.Subtask;
import com.example.tasksmanager.model.Task;
import com.example.tasksmanager.service.GroupService;
import com.example.tasksmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("groups/{groupId}/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final GroupService groupService;
    private final TaskService taskService;

    @GetMapping("/{taskId}")
    Task getTaskForGroup(@PathVariable Long groupId, @PathVariable Long taskId) {
        return groupService.getTaskForGroup(groupId, taskId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("@authComponent.hasGroupPermission(#groupId)")
    Task addTaskToGroup(@PathVariable Long groupId, @RequestBody TaskDto task) {
        return groupService.addTaskToGroup(groupId, task);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("@authComponent.hasGroupPermission(#groupId)")
    void deleteTask(@PathVariable Long groupId, @PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PostMapping("/{taskId}/subtasks")
    @PreAuthorize("@authComponent.hasGroupPermission(#groupId)")
    Subtask addSubtaskToTask(@PathVariable Long groupId, @PathVariable Long taskId, @RequestBody SubtaskDto subtask) {
        return taskService.addSubtaskToTask(taskId, subtask);
    }
}
