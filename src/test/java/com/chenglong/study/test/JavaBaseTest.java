package com.chenglong.study.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author v_longcheng
 * @date 2019/10/11
 * @description
 */
@Slf4j
public class JavaBaseTest {

    @Test
    public void test() {

        byte b = (byte) 0;
        short s = (short) 0;// (-2^15,2^16-1)
        int i = 0;//
        long l = 0L;

        // float单精度浮点数占用内存小，精度小数点后8位
        // double双精度浮点数占用内存大，精度小数点后16位
        float f = 0.0F;
        double d = 0.0D;
        boolean bo = false;
        char c = '1';


        System.out.println(0.432784932743274893274329F);
        System.out.println(3.5435436436437657657657657657D);

    }


    @Test
    public void test1() {

        int i = 0;
        int i1 = 10;

        i = +i1;
        System.out.println("i = + i1:" + i);

        int j = 0;
        int j1 = 10;

        j += j1;

        System.out.println("j += j1:" + j);

    }


}
