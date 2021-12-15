package com.example.foo_spring_boot.repository;

import com.example.foo_spring_boot.model.Message;
import lombok.NonNull;

import java.util.List;

public interface MessageRepository {
    List<Message> findAll() throws InterruptedException;
}
