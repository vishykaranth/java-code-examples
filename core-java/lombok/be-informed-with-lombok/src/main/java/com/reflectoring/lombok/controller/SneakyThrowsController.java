package com.reflectoring.lombok.controller;

import com.reflectoring.lombok.service.SneakyThrowsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class SneakyThrowsController {

    private final SneakyThrowsService service;

    public SneakyThrowsController(SneakyThrowsService service) {
        this.service = service;
    }


    @RequestMapping(value = "/api/sneakyThrows", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> sneakyThrows() {
        service.getFileData();
        return Collections.singletonMap("status", "SUCCESS");
    }

    /*
    Might be a bad design to add @SneakyThrows to multiple bubbling checked exceptions.
     */
    @ExceptionHandler(IOException.class)
    public Map<String, String> handleException(IOException e) {
        e.printStackTrace();
        return Collections.singletonMap("status", "FAIL");
    }
}
