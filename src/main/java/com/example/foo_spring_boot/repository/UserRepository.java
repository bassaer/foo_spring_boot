package com.example.foo_spring_boot.repository;

import com.example.foo_spring_boot.model.User;
import lombok.NonNull;

public interface UserRepository {
    User find(@NonNull final String id);
}
