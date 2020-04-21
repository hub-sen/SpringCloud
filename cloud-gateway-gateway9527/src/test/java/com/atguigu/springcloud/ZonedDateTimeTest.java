package com.atguigu.springcloud;

import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/4/21 11:16
 * </pre>
 */
public class ZonedDateTimeTest {
    @Test
    public void getZonedDateTime() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("now = " + now);
    }
}
