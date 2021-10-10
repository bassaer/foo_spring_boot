package com.example.foo_spring_boot.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private final String id;
    private final String name;
    private final Integer rank;
}
