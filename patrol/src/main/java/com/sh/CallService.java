package com.sh;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class CallService {

    @Resource
    private RestTemplate restTemplate;


    public String call() {
        String url = "http://control/hello";
        String result = restTemplate.getForObject(url, String.class);
        log.info("call control result:{}", result);
        return result;
    }
}
