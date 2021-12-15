package com.example.foo_spring_boot.repository;

import com.example.foo_spring_boot.model.Article;
import lombok.NonNull;

import java.util.List;

public interface ArticleRepository {
    List<Article> findAll() throws InterruptedException;
}
