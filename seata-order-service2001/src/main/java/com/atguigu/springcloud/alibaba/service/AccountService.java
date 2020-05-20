package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/5/20 17:20
 * </pre>
 */
@FeignClient("seata-account-service")
public interface AccountService {

    @PostMapping("/account/decrease")
    CommonResult<Void> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
