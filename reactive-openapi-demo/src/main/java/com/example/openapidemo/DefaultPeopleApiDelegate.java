package com.example.openapidemo;

import javax.annotation.PostConstruct;

import com.example.openapidemo.api.PeopleApiDelegate;
import com.example.openapidemo.model.Person;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import org.springframework.web.server.ServerWebExchange;

@Slf4j
@Service
public class DefaultPeopleApiDelegate implements PeopleApiDelegate {

    @PostConstruct
    void init() {
        log.info("Using DefaultPeopleApiDelegate!");
    }

    @Override
    public Mono<ResponseEntity<Person>> getPeopleId(String id, ServerWebExchange exchange) {
        return Mono.just(ResponseEntity.ok(new Person()
            .id(id)
            .name("Paolo")
            .surname("Contessi")
            .age(34)));
    }

}