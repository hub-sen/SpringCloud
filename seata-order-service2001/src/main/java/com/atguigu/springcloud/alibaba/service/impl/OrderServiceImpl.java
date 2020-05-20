package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.OrderDao;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.AccountService;
import com.atguigu.springcloud.alibaba.service.OrderService;
import com.atguigu.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/5/20 17:20
 * </pre>
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "sen_tx_group", rollbackFor = Exception.class)
    public void create(Order order) {
        // 1, 创建订单
        log.info("--------> 开始创建订单");
        orderDao.create(order);
        log.info("--------> 订单创建完成");
        // 2, 减少库存
        log.info("--------> 调用库存微服务, 开始减少库存");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("--------> 调用库存微服务结束");
        // 3, 减少money
        log.info("--------> 调用账户微服务, 开始减少money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("--------> 调用账户微服务结束");
        // 4, 更新订单状态
        log.info("--------> 更新订单状态, 开始");
        orderDao.update(order.getUserId(), 0);
        log.info("--------> 更新订单状态, 结束 (*^_^*)");

    }
}
