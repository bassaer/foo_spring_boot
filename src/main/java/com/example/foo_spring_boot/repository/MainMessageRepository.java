package com.example.foo_spring_boot.repository;

import com.example.foo_spring_boot.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class MainMessageRepository implements MessageRepository {
    @Override
    public List<Message> findAll() throws InterruptedException {
        log.info("find message");
        Thread.sleep(1000);
        log.info("got message");
        return List.of(
            Message.builder()
                .id("M-")
                .title("message-1")
                .text("this is 1st message")
                .build()
        );
    }
}
