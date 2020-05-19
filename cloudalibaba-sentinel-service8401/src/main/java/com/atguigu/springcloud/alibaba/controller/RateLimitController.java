package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.handler.CustomerBlockHandler;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/5/19 15:50
 * </pre>
 */
@RestController
@Slf4j
@RequestMapping("/rateLimit")
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult<Payment> byResource() {
        return new CommonResult<>(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public CommonResult<Payment> handleException(BlockException exception) {
        return new CommonResult<>(444, exception.getClass().getCanonicalName() + "\t服务不可用");
    }

    @GetMapping("/byUrl")
    @SentinelResource("byUrl")
    public CommonResult<Payment> byUrl() {
        return new CommonResult<>(200, "按URL限流测试OK", new Payment(2020L, "serial002"));
    }

    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException2")
    public CommonResult<Payment> customerBlockHandler() {
        return new CommonResult<>(200, "按自定义限流限流测试OK", new Payment(2020L, "serial003"));
    }
}
