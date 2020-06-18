package com.chenglong.study.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author v_longcheng
 * @date 2019/7/1
 * @description
 */
@Slf4j
public class JvmTest {

    @Test
    public void test() {
        // allocate 4M space
        byte[] b = new byte[4 * 1024 * 1024];
        System.out.println("first allocate");
        // allocate 4M space
        b = new byte[4 * 1024 * 1024];
        System.out.println("second allocate");
    }
}
