package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/4/1 15:24
 * </pre>
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced // 使用 @LoadBalanced 赋予 RestTemplate 负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
