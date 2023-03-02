package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyApp {
    
    @GetMapping("/")
    public String greet() {
        return "Hello, world!";
    }

    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
