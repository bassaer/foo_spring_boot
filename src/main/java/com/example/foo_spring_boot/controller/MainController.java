package com.example.foo_spring_boot.controller;

import com.example.foo_spring_boot.model.Response;
import com.example.foo_spring_boot.model.User;
import com.example.foo_spring_boot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class MainController {

    private final UserService userService;

    @RequestMapping(value = "main", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response main(@RequestParam(value = "id", defaultValue = "unknown") String id) {
        return userService.get(id);
    }
}
