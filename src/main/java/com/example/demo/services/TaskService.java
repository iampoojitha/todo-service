package com.example.demo.services;

import com.example.demo.Dto.TaskDto;

public interface TaskService {

    public TaskDto createTask(TaskDto request);

    public TaskDto getTask(Long id);
}
