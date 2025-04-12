package com.example.demo.services.impl;

import com.example.demo.Dto.TaskDto;
import com.example.demo.mappers.RequestMapper;
import com.example.demo.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.example.demo.repository.TaskRepository;
import com.example.demo.services.TaskService;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final RequestMapper requestMapper;
    private final TaskRepository taskRepository;

    @Override
    public TaskDto createTask(TaskDto request) {

        TaskDto response = null;
        Task task = null;
        if (!ObjectUtils.isEmpty(request)) {
            task = requestMapper.mapToTask(request);
        }

        if (task != null) {
            taskRepository.save(task);
            response = requestMapper.mapToTaskDto(task);
        }
        return response;
    }

    @Override
    public TaskDto getTask(Long id) {
        return requestMapper.mapToTaskDto(taskRepository.getById(id));
    }
}
