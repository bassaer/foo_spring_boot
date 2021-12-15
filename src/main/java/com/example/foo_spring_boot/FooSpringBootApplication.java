package com.example.foo_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FooSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FooSpringBootApplication.class, args);
	}

}
