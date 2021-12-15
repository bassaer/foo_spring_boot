package com.example.foo_spring_boot.util;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
public class AsyncRunnerImpl implements AsyncRunner {
    @Async
    @Override
    public @NonNull <T> CompletableFuture<T> run(@NonNull Callable<T> function) {
        try {
            T result =  function.call();
            return CompletableFuture.completedFuture(result);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return CompletableFuture.completedFuture(null);
        }
    }
}
