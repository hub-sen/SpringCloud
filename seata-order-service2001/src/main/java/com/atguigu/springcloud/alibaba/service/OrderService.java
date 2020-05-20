package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.Order;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/5/20 17:19
 * </pre>
 */
public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}
