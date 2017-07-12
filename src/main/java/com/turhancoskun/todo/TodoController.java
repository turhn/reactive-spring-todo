package com.turhancoskun.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;
import java.util.Date;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("")
    public Flux<Todo> index() {
        return todoRepository.findAll();
    }

    @PostMapping("")
    public Mono<Todo> create(@RequestBody Todo todo) {
        todo.setCreatedDate(new Date());
        return todoRepository.save(todo);
    }

    @GetMapping("search/title/{key}")
    public Flux<Todo> findByTitle(@PathVariable(name = "key") String key) {
        return todoRepository.findAllByTitleContains(Mono.just(key));
    }

    @PatchMapping("complete/{id}")
    public Mono<Todo> complete(@PathVariable(name = "id") BigInteger id) {
        return todoRepository.findById(id).map(Todo::complete).flatMap(todoRepository::save);
    }

    @DeleteMapping("{id}")
    public Mono<Void> delete(@PathVariable(name = "id") BigInteger id) {
        return todoRepository.findById(id).flatMap(todoRepository::delete);
    }
}
