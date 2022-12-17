package com.example.tasksmanager.service;

import com.example.tasksmanager.model.Group;
import com.example.tasksmanager.model.Task;
import com.example.tasksmanager.repository.GroupRepository;
import com.example.tasksmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;
    private final TaskRepository taskRepository;

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Optional<Group> getGroup(Long id) {
        return groupRepository.findById(id);
    }

    public Task getTaskForGroup(Long groupId, Long taskId) {
        return taskRepository.findByIdAndGroupId(taskId, groupId);
    }

    public Group addGroup(Group group) {
        return groupRepository.save(group);
    }

    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }

    public Group editGroup(Group group) {
        Group groupEdited = groupRepository.findById(group.getId()).orElseThrow();
        groupEdited.setName(group.getName());

        return groupEdited;
    }
}
