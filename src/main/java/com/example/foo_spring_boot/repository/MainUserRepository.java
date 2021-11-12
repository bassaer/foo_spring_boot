package com.example.foo_spring_boot.repository;

import com.example.foo_spring_boot.aop.LoggerAdvice.EnableLogger;
import com.example.foo_spring_boot.model.User;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class MainUserRepository implements UserRepository{

    @EnableLogger
    @Override
    public User find(@NonNull String id) {
        log.info("MainUserRepository#find");
        return User.builder()
            .id(id)
            .name(id.length() % 2 == 0 ? "hello" : "world")
            .rank(new Random().nextInt(100))
            .build();
    }
}
