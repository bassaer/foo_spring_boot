package com.example.foo_spring_boot.repository;

import com.example.foo_spring_boot.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class MainArticleRepository implements ArticleRepository{

    @Override
    public List<Article> findAll() throws InterruptedException {
        log.info("find article");
        Thread.sleep(4000);
        log.info("got article");
        return List.of(Article.builder()
            .id("A-1")
            .title("article-1")
            .content("this is 1st article")
            .build()
        );

    }
}
