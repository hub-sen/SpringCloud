package com.atguigu.springcloud.alibaba.service;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/5/20 17:57
 * </pre>
 */
public interface StorageService {
    /**
     * 减少库存
     * @param productId
     * @param count
     */
    void decrease(Long productId,Integer count);
}
