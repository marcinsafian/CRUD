package com.crud.tasks.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AllControllersExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(AllControllersExceptionHandler.class);

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Task with given id doesn't exist!")
    public String taskNotFoundExceptionHandler() {
        LOGGER.error("No such Task");
        return "No such Task";
    }
}
