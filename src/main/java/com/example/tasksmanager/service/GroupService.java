package com.example.tasksmanager.service;

import com.example.tasksmanager.dto.TaskDto;
import com.example.tasksmanager.model.Group;
import com.example.tasksmanager.model.Task;
import com.example.tasksmanager.model.User;
import com.example.tasksmanager.repository.GroupRepository;
import com.example.tasksmanager.repository.TaskRepository;
import com.example.tasksmanager.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final UserRepository userRepository;
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

    public Task addTaskToGroup(Long groupId, TaskDto task) {
        Task newTask = new Task(
                groupId,
                task.getName(),
                task.getDescription(),
                task.getDeadlineTime(),
                false
        );

        return taskRepository.save(newTask);
    }

    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }

    @Transactional
    public Group editGroup(Group group) {
        Group groupEdited = groupRepository.findById(group.getId()).orElseThrow();
        groupEdited.setName(group.getName());

        return groupEdited;
    }

    public void addUserToGroup(Long groupId, Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        Group group = groupRepository.findById(groupId).orElse(null);

        if (user == null || group == null) {
            throw new EntityNotFoundException();
        }

        group.getParticipants().add(user);
        groupRepository.save(group);
    }
}
