package com.example.demo.services.impl;

import com.example.demo.Dto.TaskDto;
import com.example.demo.mappers.RequestMapper;
import com.example.demo.model.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.example.demo.repository.TaskRepository;
import com.example.demo.services.TaskService;

@Service
@Slf4j
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
        return requestMapper.mapToTaskDto(taskRepository.findById(id).orElseThrow(null));
    }

    @Override
    public TaskDto updateTask(TaskDto taskDto) {
        Task existingTask = taskRepository.findById(taskDto.getId())
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + taskDto.getId()));
        requestMapper.updateTaskFromDto(taskDto, existingTask);
        Task updatedTask = taskRepository.save(existingTask);
        return requestMapper.mapToTaskDto(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
