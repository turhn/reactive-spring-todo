package com.turhancoskun.todo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface TodoRepository extends ReactiveCrudRepository<Todo, BigInteger> {
    Flux<Todo> findAllByTitleContains(final Mono<String> title);
}
