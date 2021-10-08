package com.example.foo_spring_boot.controller;

import com.example.foo_spring_boot.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/main")
    public User main(@RequestParam(value = "name", defaultValue = "unknown") String name) {
        return User.builder()
            .id(123)
            .name(name)
            .build();
    }
}
