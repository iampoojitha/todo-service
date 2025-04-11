package services;

import Dto.TaskDto;
import org.springframework.scheduling.config.Task;

public interface TaskService {

    public TaskDto createTask(TaskDto request);
}
