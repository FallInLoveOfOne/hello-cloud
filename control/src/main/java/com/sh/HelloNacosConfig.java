package com.sh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloNacosConfig {
    @Value("${control.hello:默认值}")
    private String name;

    //@PostConstruct
    public void test() {
        log.info("=======nacos config={}", name);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void print() {
        log.info("======= nacos config = {}", name);
    }
}
