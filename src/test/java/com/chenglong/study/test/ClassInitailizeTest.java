package com.chenglong.study.test;

/**
 * @author v_longcheng
 * @date 2019/6/25
 * @description
 */
public class ClassInitailizeTest {


    private static final int anInt2 = 333333333;
    private static int anInt1 = 22222222;

    /**
     * 类初始化方法。编译器会按照其出现顺序，收集类变量的赋值语句、静态代码块，最终组成类初始化方法。类初始化方法一般在类初始化的时候执行。
     */
    static {
        System.out.println("静态代码块");
    }

    /**
     * 对象初始化方法。编译器会按照其出现顺序，收集成员变量的赋值语句、普通代码块，最后收集构造函数的代码，最终组成对象初始化方法。对象初始化方法一般在实例化类对象的时候执行。
     */
    private int anInt = 1111;

    public ClassInitailizeTest(int anInt) {
        this.anInt = anInt;
    }

    public static void main(String[] args) {

        System.out.println("11111111");

        System.out.println("son" + new Son());

    }


}

class Grandpa {
    static {
        System.out.println("爷爷在静态代码块");
    }

    public Grandpa() {
        System.out.println("我是爷爷~");
    }
}

class Father extends Grandpa {
    static {
        System.out.println("爸爸在静态代码块");
    }

    public Father() {
        System.out.println("我是爸爸~");
    }
}

class Son extends Father {
    static {
        System.out.println("儿子在静态代码块");
    }

    public Son() {
        System.out.println("我是儿子~");
    }
}
