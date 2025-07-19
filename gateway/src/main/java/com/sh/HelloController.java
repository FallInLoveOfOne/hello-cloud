package com.sh;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class HelloController {
    @Resource
    private CallService callService;

    @GetMapping("/")
    public String hello() {
        log.info("hello gateway");
        return "hello gateway";
    }

    @GetMapping("/call/service")
    public Mono<String> callService() {
        return callService.call();
    }
}
