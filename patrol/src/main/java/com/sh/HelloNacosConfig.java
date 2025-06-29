package com.sh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RefreshScope
public class HelloNacosConfig {
    @Value("${patrol.hello:默认值}")
    private String name;

    @GetMapping("/nacosConfig")
    public String nacosConfigValue() {
        log.info("=======nacos config={}", name);
        return name;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void print() {
        log.info("======= nacos config = {}", name);
    }
}
