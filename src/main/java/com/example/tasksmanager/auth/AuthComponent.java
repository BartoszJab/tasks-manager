package com.example.tasksmanager.auth;

import com.example.tasksmanager.model.Group;
import com.example.tasksmanager.repository.GroupRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthComponent {

    private final GroupRepository groupRepository;

    public AuthComponent(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public boolean hasGroupPermission(Long groupId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Group group = groupRepository.findById(groupId).orElseThrow();

        return group.getParticipants().stream().anyMatch(u -> u.getUsername().equals(authentication.getName()));
    }
}
