package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.facade.TaskFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class TaskController {

    @Autowired
    TaskFacade taskFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/tasks")
    public List<TaskDto> getTasks() {
        return taskFacade.getTasks();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tasks/{taskId}")
    public TaskDto getTask(@PathVariable(name = "taskId") Long taskId) throws TaskNotFoundException {
        return taskFacade.getTask(taskId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/tasks", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Task successful created")
    public Long createTask(@RequestBody TaskDto taskDto) {
        return taskFacade.createTask(taskDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/tasks")
    public TaskDto updateTask(@RequestBody TaskDto taskDto) {
        return taskFacade.updateTask(taskDto);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/tasks/{taskId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Task successful deleted")
    public void deleteTask(@PathVariable(name = "taskId") Long taskId) throws TaskNotFoundException {
        taskFacade.deleteTask(taskId);
    }
}