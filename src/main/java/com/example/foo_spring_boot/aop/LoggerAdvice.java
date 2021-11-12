package com.example.foo_spring_boot.aop;

import com.example.foo_spring_boot.model.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.util.Objects.nonNull;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class LoggerAdvice {

    @Around("@annotation(enableLogger)")
    public Object aroundLog(@NonNull final ProceedingJoinPoint joinPoint, @NonNull final EnableLogger enableLogger) throws Throwable {
        log.info("Before LoggerAdvice...");
        User result = (User) joinPoint.proceed();
        if (nonNull(result)) {
            log.info("[User] {}", result);
        }
        log.info("After LoggerAdvice...");
        return result;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface EnableLogger {
    }
}
