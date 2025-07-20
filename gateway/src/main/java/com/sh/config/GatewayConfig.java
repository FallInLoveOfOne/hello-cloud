package com.sh.config;

import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.property.DynamicSentinelProperty;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Slf4j
//@Component
public class GatewayConfig {
    @PostConstruct
    public void initSentinel() {
        // 强制初始化空规则集
        GatewayRuleManager.register2Property(new DynamicSentinelProperty<>(Collections.emptySet()));
        log.info("Sentinel 网关规则管理器已初始化");
    }
}
