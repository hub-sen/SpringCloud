package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/4/22 11:04
 * </pre>
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/info")
    public String getInfo(){
        return "serverPort: " + serverPort + "\nconfigInfo: " + configInfo;
    }
}
