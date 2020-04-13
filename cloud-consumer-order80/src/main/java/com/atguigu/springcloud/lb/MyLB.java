package com.atguigu.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/4/13 11:11
 * </pre>
 */
@Component
@Slf4j
public class MyLB implements LoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        log.info("******** 第{}次访问 ********", next);
        return next;
    }


    @Override
    public ServiceInstance serviceInstance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
