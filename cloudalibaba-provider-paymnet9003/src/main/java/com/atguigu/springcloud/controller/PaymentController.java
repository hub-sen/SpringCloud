package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/5/20 10:29
 * </pre>
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1L, "111111111111111111"));
        hashMap.put(2L, new Payment(2L, "222222222222222222"));
        hashMap.put(3L, new Payment(3L, "333333333333333333"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        return new CommonResult<>(200, "from mysql, serverPort: " + serverPort, payment);
    }
}
