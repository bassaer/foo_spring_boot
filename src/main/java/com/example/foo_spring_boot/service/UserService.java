package com.example.foo_spring_boot.service;

import com.example.foo_spring_boot.model.Article;
import com.example.foo_spring_boot.model.Message;
import com.example.foo_spring_boot.model.Response;
import com.example.foo_spring_boot.repository.ArticleRepository;
import com.example.foo_spring_boot.repository.MessageRepository;
import com.example.foo_spring_boot.repository.UserRepository;
import com.example.foo_spring_boot.util.AsyncRunner;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static java.util.Objects.isNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;
    private final MessageRepository messageRepository;
    private final AsyncRunner asyncRunner;

    @Nullable
    public Response find(@NonNull final String id) {
        CompletableFuture<List<Article>>  futureArticles = asyncRunner.run(articleRepository::findAll);
        CompletableFuture<List<Message>> futureMessages = asyncRunner.run(messageRepository::findAll);

        List<Article> articles = get(futureArticles);
        List<Message> messages = get(futureMessages);

        if (isNull(articles) || isNull(messages)) {
            log.info("articles: " + articles);
            log.info("messages:" + messages);
        }

        log.info("create response");
        return Optional.ofNullable(userRepository.find(id))
            .map(user -> new ModelMapper().map(user, Response.class))
            .map(res -> {
                res.setArticles(articles);
                res.setMessages(messages);
                return res;
            })
            .orElse(null);
    }

    private <T> T get(@NonNull final Future<T> future) {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getLocalizedMessage());
        }
        return null;
    }
}
