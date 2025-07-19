package com.sh;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class CallService {

    @Resource
    private WebClient.Builder webClientBuilder;


    public Mono<String> call() {
        log.info("webClientBuilder.getClass={}", webClientBuilder.getClass());
        return webClientBuilder
                .build()
                .get()
                .uri("http://control/hello")
                .retrieve()
                .bodyToMono(String.class);
    }
}
