package com.thehecklers.sburMysql;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.time.Instant;

@EnableScheduling
@Component
@RequiredArgsConstructor
class PlaneFinderPoller {
    @NonNull
    private final AircraftRepository repository;
    private WebClient client = WebClient.create("http://localhost:7634/aircraft");

    @Scheduled(fixedRate = 1000)
    private void pollPlanes(){
//        repository.deleteAll();

//        client.get()
//                .retrieve()
//                .bodyToFlux(Aircraft.class)
//                .toStream()
//                .forEach(repository::save);
        repository.findAll().forEach(System.out::println);
    }
}
