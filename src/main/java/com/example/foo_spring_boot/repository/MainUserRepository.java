package com.example.foo_spring_boot.repository;

import com.example.foo_spring_boot.model.User;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MainUserRepository implements UserRepository{

    @Override
    public User find(@NonNull String id) {
        return User.builder()
            .id(id)
            .name(id.length() % 2 == 0 ? "hello" : "world")
            .rank(new Random().nextInt(100))
            .build();
    }
}
