package com.vp.app.roomservice.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Slf4j
@Component
public class ReactiveLogginFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        // GET /api/rooms - 200 OK(81 s)
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        Instant start = Instant.now();
        String method = request.getMethod().name();
        String path = request.getURI().getPath();

        log.info("=>: {}, Path: {}", method, path);

        return chain.filter(exchange)
                .doOnSuccess(aVoid -> {
                    Instant end = Instant.now();
                    long duration = end.toEpochMilli() - start.toEpochMilli();
                    log.info("<=: {}, Path: {}, Status: {}, Duration: {} ms", method, path, response.getStatusCode(), duration);
                })
                .doOnError(throwable -> {
                    Instant end = Instant.now();
                    long duration = end.toEpochMilli() - start.toEpochMilli();
                    log.error("<=: {}, Path: {}, Error: {}, Duration: {} ms", method, path, throwable.getMessage(), duration);
                });

    }
}
