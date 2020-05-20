package com.atguigu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/5/20 17:53
 * </pre>
 */
@Mapper
public interface StorageDao {
    /**
     * 减少库存
     * @param productId
     * @param count
     */
    void decrease(@Param("productId")Long productId, @Param("count") Integer count);
}
