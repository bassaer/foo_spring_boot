package com.example.foo_spring_boot.model;

import lombok.Data;

import java.util.List;

@Data
public class Response {
    String id;
    String name;
    Integer rank;
    List<Article> articles;
    List<Message> messages;
}
