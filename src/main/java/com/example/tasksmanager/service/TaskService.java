package com.example.tasksmanager.service;

import com.example.tasksmanager.dto.SubtaskDto;
import com.example.tasksmanager.model.Subtask;
import com.example.tasksmanager.repository.SubtaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final SubtaskRepository subtaskRepository;

    public Subtask addSubtaskToTask(Long taskId, SubtaskDto subtask) {
        Subtask newSubtask = new Subtask(taskId, subtask.getContent(), false);
        return subtaskRepository.save(newSubtask);
    }
}
