package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/4/13 10:08
 * </pre>
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        // 随机
        return new RandomRule();
    }
}
