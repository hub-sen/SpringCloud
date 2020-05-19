package com.atguigu.springcloud.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/5/19 16:23
 * </pre>
 */
public class CustomerBlockHandler {
    public static CommonResult<Payment> handlerException1(BlockException exception) {
        return new CommonResult<>(4444,"按自定义限流限流, global handlerException---1");
    }
    public static CommonResult<Payment> handlerException2(BlockException exception) {
        return new CommonResult<>(4444,"按自定义限流限流, global handlerException---2");
    }
}
