package com.crud.tasks.facade;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskFacade {

    @Autowired
    private DbService service;

    @Autowired
    private TaskMapper taskMapper;

    public List<TaskDto> getTasks() {
        return taskMapper.mapToTaskDtoList(service.getAllTasks());
    }

    public TaskDto getTask(Long taskId) throws TaskNotFoundException {
        return taskMapper.mapToTaskDto(service.getTask(taskId).orElseThrow(TaskNotFoundException::new));
    }

    public void deleteTask(Long taskId) throws TaskNotFoundException {
        try {
            service.deleteTask(taskId);
        } catch(Exception e) {
            throw new TaskNotFoundException();
        }
    }

    public TaskDto updateTask(TaskDto taskDto) {
        return taskMapper.mapToTaskDto(service.saveTask(taskMapper.mapToTask(taskDto)));
    }

    public Long createTask(TaskDto taskDto) {
        return (service.saveTask(taskMapper.mapToTask(taskDto))).getId();
    }
}
