package com.example.hello_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class InfoController {
    @GetMapping("/info")
    public String info() {
        return "Spring Boot makes Java web apps easy!";
    }

    @GetMapping("/course")
    public Course course() {
        return new Course("IT-påbyggnadsutbildning - Java", "Bill & Ibrahim");
    }

    @GetMapping("/time")
    public String currentTime() {
        return LocalDateTime.now().toString();
    }
}
