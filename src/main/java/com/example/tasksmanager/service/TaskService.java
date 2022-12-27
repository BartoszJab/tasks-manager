package com.example.tasksmanager.service;

import com.example.tasksmanager.dto.SubtaskDto;
import com.example.tasksmanager.model.Subtask;
import com.example.tasksmanager.model.Task;
import com.example.tasksmanager.repository.SubtaskRepository;
import com.example.tasksmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final SubtaskRepository subtaskRepository;

    public Subtask addSubtaskToTask(Long taskId, SubtaskDto subtask) {
        Subtask newSubtask = new Subtask(taskId, subtask.getContent(), false);
        return subtaskRepository.save(newSubtask);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> findByGroupId(Long groupId) {
        return taskRepository.findByGroupId(groupId);
    }
}
