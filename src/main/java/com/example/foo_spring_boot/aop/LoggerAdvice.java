package com.example.foo_spring_boot.aop;

import com.example.foo_spring_boot.model.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.util.Objects.nonNull;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggerAdvice {

    @Around("@annotation(enableLogger)")
    public Object aroundLog(@NonNull final ProceedingJoinPoint joinPoint, @NonNull final EnableLogger enableLogger) throws Throwable{
        System.out.println("Before LoggerAdvice...");
        User result = (User) joinPoint.proceed();
        if (nonNull(result)) {
            System.out.printf("user : %s\n", result);
        }
        System.out.println("After LoggerAdvice...");
        return result;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface EnableLogger {
    }
}
