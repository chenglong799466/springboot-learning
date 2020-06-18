package com.chenglong.study.controller;

/**
 * @author v_longcheng
 * @date 2019/8/19
 * @description
 */
public class TestController {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        A a = createInstance(A.class);
        B b = createInstance(B.class);


    }

    static <T> T createInstance(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        return tClass.newInstance();

    }


    class A {
    }


    class B {
    }


}
