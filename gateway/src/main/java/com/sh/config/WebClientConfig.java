package com.sh.config;

import org.springframework.boot.actuate.metrics.web.reactive.client.ObservationWebClientCustomizer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    /**
     * 构建支持分布式链路追踪的WebClient实例
     * <p>
     * 关键解决点：
     * 1. 通过ObservationWebClientCustomizer自动注入追踪处理器
     * 2. 确保所有HTTP请求自动携带追踪头(traceparent/b3)
     * 3. 维持跨服务调用的链路上下文传递
     * <p>
     * 修复的链路问题：
     * - 原配置未集成追踪组件，导致control服务调用未纳入链路
     * - 手动调用时traceId未传递造成链路断裂
     * - Zipkin中gateway->control的调用关系缺失
     * <p>
     * 集成的Micrometer Tracing能力：
     * 1. 自动注入追踪信息到请求头：
     * - W3C TraceContext标准的traceparent头
     * - Zipkin兼容的b3头
     * 2. 完整记录HTTP请求的Span信息：
     * - 记录请求开始/结束时间戳
     * - 捕获HTTP状态码和异常信息
     * - 标记服务调用拓扑关系
     * 3. 保障跨服务调用链连续性：
     * - 自动传递当前trace上下文
     * - 支持异步调用上下文传播
     * - 确保父子Span关系正确建立
     */
    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder(ObservationWebClientCustomizer customizer) {
        WebClient.Builder builder = WebClient.builder();
        customizer.customize(builder);
        return builder;
    }
}

