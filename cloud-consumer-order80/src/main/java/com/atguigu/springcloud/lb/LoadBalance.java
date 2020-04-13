package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/4/13 11:06
 * </pre>
 */
public interface LoadBalance {
    ServiceInstance serviceInstance(List<ServiceInstance> serviceInstances);
}
