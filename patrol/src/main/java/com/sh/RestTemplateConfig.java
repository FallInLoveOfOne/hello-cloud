package com.sh;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /**
     * 使用 RestTemplateBuilder 创建 RestTemplate，
     * 可自动注入 Micrometer Tracing 拦截器，实现 traceId/spanId 传递。
     * <p>
     * 若使用 new RestTemplate()，则不会启用链路追踪。
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
