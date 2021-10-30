package com.example.foo_spring_boot.service;

import com.example.foo_spring_boot.model.Response;
import com.example.foo_spring_boot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Nullable
    public Response get(final String id) {
        return Optional.ofNullable(id)
            .map(userRepository::find)
            .map(user -> new ModelMapper().map(user, Response.class))
            .orElse(null);
    }
}
