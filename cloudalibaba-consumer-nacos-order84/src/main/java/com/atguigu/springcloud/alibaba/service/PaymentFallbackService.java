package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/5/20 11:42
 * </pre>
 */
@Component
public class PaymentFallbackService  implements PaymentService{

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(4444, "服务降级返回, --- PaymentFallbackService--- ",new Payment(id, "errorSerial"));
    }
}
