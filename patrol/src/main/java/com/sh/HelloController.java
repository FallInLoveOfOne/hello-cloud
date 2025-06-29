package com.sh;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @Resource
    private CallService callService;

    @GetMapping("/hello")
    public String hello() {
        return "hello patrol";
    }

    @GetMapping("/call/service")
    public String callService() {
        return callService.call();
    }
}
