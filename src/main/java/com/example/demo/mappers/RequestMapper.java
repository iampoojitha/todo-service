package com.example.demo.mappers;

import com.example.demo.Dto.TaskDto;
import com.example.demo.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RequestMapper {

    Task mapToTask(TaskDto taskDto);

    TaskDto mapToTaskDto(Task task);

    void updateTaskFromDto(TaskDto dto, @MappingTarget Task entity);
}
