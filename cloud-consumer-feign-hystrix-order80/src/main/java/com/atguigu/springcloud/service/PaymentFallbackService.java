package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/4/14 10:35
 * </pre>
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-------- PaymentFallbackService Fallback paymentInfo_OK /(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "-------- PaymentFallbackService Fallback paymentInfo_Timeout /(ㄒoㄒ)/~~";
    }
}
