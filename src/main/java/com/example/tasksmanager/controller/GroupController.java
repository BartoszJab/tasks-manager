package com.example.tasksmanager.controller;

import com.example.tasksmanager.dto.TaskDto;
import com.example.tasksmanager.model.Group;
import com.example.tasksmanager.model.Task;
import com.example.tasksmanager.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/{id}")
    Group getGroup(@PathVariable Long id) {
        return groupService.getGroup(id).orElseThrow();
    }

    @GetMapping("/{groupId}/tasks/{taskId}")
    Task getTaskForGroup(@PathVariable Long groupId, @PathVariable Long taskId) {
        return groupService.getTaskForGroup(groupId, taskId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Group addGroup(@RequestBody Group group) {
        return groupService.addGroup(group);
    }

    @PostMapping("/{groupId}/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    Task addTaskToGroup(@PathVariable Long groupId, @RequestBody TaskDto task) {
        return groupService.addTaskToGroup(groupId, task);
    }

    @PutMapping
    Group editGroup(@RequestBody Group group) {
        return groupService.editGroup(group);
    }

    @DeleteMapping("/{id}")
    void deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
    }
}
