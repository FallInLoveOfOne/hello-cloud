package com.sh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class ControlMain {
    public static void main(String[] args) {
        SpringApplication.run(ControlMain.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "hello control";
    }

}