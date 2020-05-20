package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/5/20 17:20
 * </pre>
 */
@FeignClient("seata-storage-service")
public interface StorageService {

    @PostMapping("/storage/decrease")
    CommonResult<Void> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
