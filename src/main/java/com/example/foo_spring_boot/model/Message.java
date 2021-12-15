package com.example.foo_spring_boot.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Message {
    private String id;
    private String title;
    private String text;
}
