package com.example.foo_spring_boot.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Article {
    private final String id;
    private final String title;
    private final String content;
}
