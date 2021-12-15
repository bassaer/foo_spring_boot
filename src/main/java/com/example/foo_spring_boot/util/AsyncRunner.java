package com.example.foo_spring_boot.util;

import lombok.NonNull;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

public interface AsyncRunner {
    @NonNull
    <T> CompletableFuture<T> run(@NonNull final Callable<T> function);
}
