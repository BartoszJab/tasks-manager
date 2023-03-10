package com.example.tasksmanager.controller;

import com.example.tasksmanager.model.Group;
import com.example.tasksmanager.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Group addGroup(@RequestBody Group group) {
        return groupService.addGroup(group);
    }

    @PostMapping("/{groupId}/users/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("@authComponent.hasGroupPermission(#groupId)")
    void addUserToGroup(@PathVariable Long groupId, @PathVariable Long userId) {
        groupService.addUserToGroup(groupId, userId);
    }

    @PutMapping
    @PreAuthorize("@authComponent.hasGroupPermission(#group.id)")
    Group editGroup(@RequestBody Group group) {
        return groupService.editGroup(group);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("@authComponent.hasGroupPermission(#id)")
    void deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
    }
}
