package com.sh.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Hooks;

@Configuration
public class ReactorMdcConfiguration {

    /**
     * 启用 Reactor 的自动上下文传播机制。
     * <p>
     * 背景：
     * 在基于 Project Reactor（即 Spring WebFlux）构建的应用中，请求处理是异步/非阻塞的，
     * 会在多个线程之间切换。Micrometer Tracing 使用 ThreadLocal 存储 traceId 和 spanId，
     * 而 ThreadLocal 默认并不会在 Reactor 的线程切换中自动传递。
     * <p>
     * 问题：
     * - traceId/spanId 是存储在 ThreadLocal 中的（通过 MDC 或 Tracer 实现）
     * - WebFlux 异步执行过程中会频繁更换线程，导致 ThreadLocal 上下文丢失
     * - 日志输出中无法看到 traceId、spanId，导致链路日志中断
     * <p>
     * 作用：
     * - Hooks.enableAutomaticContextPropagation() 是 Micrometer 提供的 API
     * - 它开启 Reactor 的上下文传播支持，将 Reactor 的 Context 和 ThreadLocal（如 MDC）自动桥接
     * - 保证 traceId、spanId 能随着 Reactor 的执行流自动传递
     * - 实现日志 traceId/spanId 输出、链路跟踪跨线程不中断
     * <p>
     * Micrometer 1.11+ 推荐在启动时显式调用本方法，确保 tracing 能正常工作于 WebFlux/reactor 环境中。
     */
    @PostConstruct
    public void init() {
        // 开启自动上下文传播：traceId、spanId等可被日志MDC访问
        Hooks.enableAutomaticContextPropagation();
    }
}


