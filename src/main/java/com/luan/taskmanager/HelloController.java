package com.luan.taskmanager;

import org.springframework.web.bind.annotation.GetMapping; // Importing GetMapping for handling HTTP GET requests
import org.springframework.web.bind.annotation.RestController; // Importing RestController for creating RESTful web services

@RestController // This annotation indicates that this class is a REST controller
public class HelloController {

    @GetMapping("/hello") // This annotation maps HTTP GET requests to the hello() method
    public String hello() {
        return "Olá! A API está funcionando!"; // esse método retorna uma string simples
    }
}
