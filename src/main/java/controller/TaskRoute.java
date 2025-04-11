package controller;

import Dto.TaskDto;
import config.AppConfig;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import services.TaskService;

@RestController(AppConfig.API_PATH)
@Slf4j
public class TaskRoute {

    @Autowired
    private static TaskService taskService;

    @PostMapping(AppConfig.CREATE_TASK)
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto request) {
        try {
            return ResponseEntity.ok(taskService.createTask(request));
        } catch (IllegalArgumentException e) {
            log.error(AppConfig.SOMETHING_WENT_WRONG + e.getMessage());
            throw new IllegalArgumentException("Invalid Request: " + e.getMessage());
        }
    }

    }
