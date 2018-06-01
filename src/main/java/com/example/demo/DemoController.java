package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.concurrent.CompletableFuture;

@Controller
public class DemoController {

    private final String message;

    @Autowired
    public DemoController(@Value("${application.message:hello world}") String message) {
        this.message = message;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public CompletableFuture<ResponseEntity<String>> root() {
        return CompletableFuture.supplyAsync(() -> new ResponseEntity<>(message, HttpStatus.OK));
    }
}
