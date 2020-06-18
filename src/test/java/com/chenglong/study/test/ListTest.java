package com.chenglong.study.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author v_longcheng
 * @date 2019/10/11
 * @description
 */
public class ListTest {

    public static void main(String[] args) {

        String s = new String("12345");

        String[] strings = new String[3];
        strings[0] = "1";
        strings[1] = "2";

        // 数组类型不是和普通类一样，以一个全限定路径名+类名来作为自己的唯一标示的，
        // 而是以[+一个或者多个L+数组元素类全限定路径+类来最为唯一标示的
        System.out.println(strings);

        // List中没有而ArrayList中有的方法将不能被list对象使用。这种用法属于Java的多态特性。
        // 当使用多态方式调用方法时，首先检查父类中是否有该方法，如果没有，则编译错误；如果有，再去调用子类的该同名方法。


        // 1.只能调用父类中有的方法
        // 2.实际调用子类中的同名方法
        // 3.向上造型（多态）
        List<String> userNames = new ArrayList<>();
        userNames.add("123");
        userNames.add("1234");
        userNames.add(s);
        userNames.add("H");
        ((ArrayList<String>) userNames).trimToSize();

        List<String> userNames1111 = new ArrayList<>();
        userNames1111.add("123");
        userNames1111.add("1234");
        userNames1111.add(s);
        userNames1111.add("H");

        s = "1111111";



	/*	for (String userName : userNames) {

			int i = 1;
			if (userName.equals("Hollis")) {
				System.out.println(++i);
				userNames1111.remove(userName);
			}


		}*/

        System.out.println("userNames1111:" + userNames1111);
        System.out.println("userNames:" + userNames);



/*		final Map<Boolean, List<String>> hollis = userNames.stream().collect(Collectors.groupingBy(o -> o.equals("Hollis")));

		for (String userName : userNames) {
			if (userName.equals("Hollis")) {
				hollis.remove(false);
			}
		}

		System.out.println("userNames:" + userNames);
		System.out.println("hollis:" + hollis);





		System.out.println("0---"+System.identityHashCode(userNames.get(0)));
		System.out.println("1------"+System.identityHashCode(userNames.get(1)));
		System.out.println("2-------"+System.identityHashCode(userNames.get(2)));
		System.out.println("3----------"+System.identityHashCode(userNames.get(3)));


		System.out.println("false----------"+System.identityHashCode(hollis.get(false)));
		System.out.println("true----------"+System.identityHashCode(hollis.get(true)));



		System.out.println(System.identityHashCode(userNames));

		System.out.println(System.identityHashCode(hollis));

		User mUser1 = new User("zhangsan", "123456");
		User mUser = new User("zhangsan", "123456");
		System.out.println(mUser == mUser1);
		System.out.println(mUser.equals(mUser1));
		System.out.println(System.identityHashCode(mUser1));
		System.out.println(System.identityHashCode(mUser));

		Object o = new Object();

		o.equals(o);


		byte b = (byte)0;*/


    }


}


class User {
    String name = "";
    String pwd = "";

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }
}
