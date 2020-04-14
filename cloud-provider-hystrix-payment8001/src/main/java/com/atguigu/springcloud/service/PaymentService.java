package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/4/13 14:37
 * </pre>
 */
@Service
public class PaymentService {

    @Value("${server.port}")
    private String serverPort;

    public String paymentInfo_OK(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + "\tpaymentInfo_OK, id: " + id + "\tO(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_Timeout(Integer id) {
        int timeout = 1000;
        // int temp = 10/0;
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName() + "\tpaymentInfo_Timeout, id: " + id + "\t耗时(毫秒): " + timeout;
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + "\t" + serverPort + "\t系统繁忙或运行报错, 请稍后再试, id: " + id + "\t/(ㄒoㄒ)/~~";
    }
}
