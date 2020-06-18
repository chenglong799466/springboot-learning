package com.chenglong.study.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author v_longcheng
 * @date 2019/7/1
 * @description
 */
@Slf4j
public class Refect {


    //@Test
    public static void test(String[] args) {

        try {
            //1. 使用 Class.forName 静态方法。当你知道该类的全路径名时，你可以使用该方法获取 Class 类对象。
            Class c = Class.forName("com.chenglong.study.test.Refect");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //2. 使用 .class 方法。
        Class c1 = Refect.class;

        // 3. 使用类对象的 getClass() 方法
        Refect refect = new Refect();
        Class c2 = refect.getClass();


    }

}
