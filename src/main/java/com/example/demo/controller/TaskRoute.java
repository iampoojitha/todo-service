package com.example.demo.controller;

import com.example.demo.Dto.TaskDto;
import com.example.demo.config.AppConfig;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.TaskService;

import java.util.Arrays;

@RestController
@RequestMapping(AppConfig.API_PATH)
@Slf4j
@RequiredArgsConstructor
public class TaskRoute {

    @Autowired
    private TaskService taskService;

    @PostMapping(AppConfig.CREATE_TASK)
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody TaskDto request) throws Exception {
        try {
            return ResponseEntity.ok(taskService.createTask(request));
        } catch (IllegalArgumentException e) {
            log.error(AppConfig.SOMETHING_WENT_WRONG + e.getMessage());
            throw new IllegalArgumentException("Invalid Request: " + e.getMessage());
        } catch (Exception e) {
            log.error("failed to create a task with the details:"+request);
            throw new Exception(AppConfig.SOMETHING_WENT_WRONG + Arrays.toString(e.getStackTrace()));
        }
    }

    @GetMapping(AppConfig.GET_TASK)
    public ResponseEntity<TaskDto> getTask(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity.ok(taskService.getTask(id));
        } catch (Exception e) {
            log.error("failed to fetch the task details with the id:"+id);
            throw new Exception(AppConfig.SOMETHING_WENT_WRONG + Arrays.toString(e.getStackTrace()));
        }
    }

    @PutMapping(AppConfig.UPDATE_TASK)
    public ResponseEntity<TaskDto> updateTask(@Valid @RequestBody TaskDto request) throws Exception {
        try {
            return ResponseEntity.ok(taskService.updateTask(request));
        } catch (Exception e) {
            log.error("failed to update the task with id {} and request: {}", request.getId(), request);
            throw new Exception(AppConfig.SOMETHING_WENT_WRONG + Arrays.toString(e.getStackTrace()));
        }
    }

    @DeleteMapping(AppConfig.DELETE_TASK)
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) throws Exception {
        try {
            taskService.deleteTask(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("failed to delete the task with id {}", id);
            throw new Exception(AppConfig.SOMETHING_WENT_WRONG + Arrays.toString(e.getStackTrace()));
        }
    }

    }
