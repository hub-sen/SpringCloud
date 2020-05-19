package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/4/30 17:40
 * </pre>
 */
@RestController
@Slf4j
public class FlowLimitController {


    @GetMapping("/testA")
    public String testA() {
        return "******** testA ********";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName()+"\t...testB");
        return "******** testB ********";
    }

    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName()+"\t...testD");
        return "******** testRT ********";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info(Thread.currentThread().getName()+"\t...test异常比例");

        int i = 10 / 0;

        return "******** test异常比例 ********";
    }

    @GetMapping("/testF")
    public String testF() {
        log.info(Thread.currentThread().getName()+"\t...test异常数");

        int i = 10 / 0;

        return "******** test异常数 ********";
    }



    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "******** testHotKey ********";
    }

    public String dealTestHotKey(String p1, String p2, BlockException exception) {
        return "******** deal_testHotKey, /(ㄒoㄒ)/~~ ********";
    }
}
