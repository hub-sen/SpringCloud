package com.atguigu.springcloud.alibaba.service;

import java.math.BigDecimal;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/5/20 18:23
 * </pre>
 */
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
