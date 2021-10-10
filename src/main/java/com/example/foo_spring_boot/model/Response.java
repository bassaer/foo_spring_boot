package com.example.foo_spring_boot.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class Response {
    @NonNull
    String id;
    @NonNull
    String name;
    @NonNull
    Integer rank;
}
