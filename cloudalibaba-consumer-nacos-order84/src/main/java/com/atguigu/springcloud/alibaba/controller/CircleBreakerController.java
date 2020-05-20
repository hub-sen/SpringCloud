package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.service.PaymentService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/5/20 10:58
 * </pre>
 */
@RestController
public class CircleBreakerController {

    @Value("${service-url.nacos-payment-service}")
    private String serverURL;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PaymentService paymentService;


    @GetMapping("/consumer/fallback/{id}")
//    @SentinelResource("fallback") // 没有配置
//    @SentinelResource(value = "fallback", fallback = "fallbackHandler") // fallback 只负责业务异常
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler") //  blockHandler 只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback", blockHandler = "blockHandler", fallback = "fallbackHandler", exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> paymentInfo(@PathVariable("id") Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(serverURL + "/paymentSQL/" + id, CommonResult.class, id);

        if (4 == id) {
            throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常...");
        } else if (Objects.isNull(result.getData())) {
            throw new NullPointerException("NullPointerException, 该id: " + id + ", 没有对应的记录");
        }

        return result;
    }

    public CommonResult<Payment> fallbackHandler(@PathVariable("id") Long id, Throwable throwable) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<Payment>(4444, "兜底异常fallbackHandler, exception: " + throwable.getMessage(), payment);
    }

    public CommonResult<Payment> blockHandler(@PathVariable("id") Long id, BlockException blockException) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<Payment>(4444, "兜底异常blockHandler, exception: " + blockException.getMessage(), payment);
    }

    @GetMapping("/consumer/openfeign/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }


}
