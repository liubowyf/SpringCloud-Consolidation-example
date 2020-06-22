package com.liubo.gatewayserver.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @ClassNameCurrentLimitConfig
 * @Description 网关限流配置类
 * @Author liubo
 * @Date 2020/6/17 17:02
 */
@Configuration
public class IpLimitConfig {

	/**
	 * 功能描述 [设置限流方式为根据ip限流]
	 * @author liubo
	 * @date 2020/6/17
	 * @param []
	 * @return org.springframework.cloud.gateway.filter.ratelimit.KeyResolver
	 */
	@Bean(value = "ipLimit")
	public KeyResolver ipLimit(){
		return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
	}


}
