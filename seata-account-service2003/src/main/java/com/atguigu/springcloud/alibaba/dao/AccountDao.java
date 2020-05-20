package com.atguigu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/5/20 18:20
 * </pre>
 */
@Mapper
public interface AccountDao {
    /**
     * 账户扣减
     * @param userId
     * @param money
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
