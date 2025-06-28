package com.sh;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class ControlMain {
    public static void main(String[] args) {
        SpringApplication.run(ControlMain.class, args);
    }

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "hello control";
    }

}