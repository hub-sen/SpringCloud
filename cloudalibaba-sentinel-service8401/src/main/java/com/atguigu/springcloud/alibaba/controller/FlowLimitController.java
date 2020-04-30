package com.atguigu.springcloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/4/30 17:40
 * </pre>
 */
@RestController
public class FlowLimitController {


    @GetMapping("/testA")
    public String testA() {
        return "******** testA ********";
    }

    @GetMapping("/testB")
    public String testB() {
        return "******** testB ********";
    }
}
