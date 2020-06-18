package com.chenglong.study.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.DecimalFormat;

/**
 * @author v_longcheng
 * @date 2019/10/14
 * @description
 */
@Slf4j
public class DecimalFormatTest {


    public static boolean isIntegerForDouble(double obj) {
        double eps = 1e-10;  // 精度范围
        return obj - Math.floor(obj) < eps;
    }

    @Test
    public void test() {

        String s = "0.01";

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        final Double x = Double.valueOf(s);
        System.out.println(x.intValue());

        if (x - x.intValue() > 0) {
            System.out.println("111");
        }


        System.out.println("isIntegerForDouble" + isIntegerForDouble(x));


        System.out.println(decimalFormat.format(x));


        System.out.println(x);

    }


}
