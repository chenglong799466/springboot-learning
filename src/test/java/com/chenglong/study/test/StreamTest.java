package com.chenglong.study.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author v_longcheng
 * @date 2019/6/12
 * @description
 */
public class StreamTest {

    private static final Logger log = LoggerFactory.getLogger(StreamTest.class);

    @Test
    public void TestList() {


        List<Object> list2 = new ArrayList<>();

        List<String> list3 = list2.stream().map(o -> o.toString()).collect(Collectors.toList());
        System.out.println("list3" + list3);

        List<Integer> list = new ArrayList<Integer>() {{
            add(10);
            add(20);
            add(30);
            add(40);
            add(50);
            add(60);
            add(70);
        }};

        List<Integer> list1 = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
        }};


        list.removeIf(o -> o % 4 == 0);


        Long.valueOf(34L);

        System.out.println(list);


        //list.stream().mapToLong(o->o).forEach(System.out::println);
        //list.stream().flatMap(o-> list.stream().skip(3)).forEach(System.out::println);


    }


    @Test
    public void testStream() {

        log.info("测试日志");


        Function<Object, Integer> function = (object) -> {
            return 1;
        };

        Function<Object, Integer> function1 = (object) -> {
            return 2;
        };

        Supplier<Map<Integer, Function<Object, Integer>>> mapSupplier = () -> {
            Map<Integer, Function<Object, Integer>> map = new HashMap<>();
            map.put(1, function);
            map.put(2, function1);

            return map;

        };


        int type = 1;
        Object object = new Object();

        System.out.println(mapSupplier.get().get(type).apply(object));


        if (type == 1) {
            // test1 logic
        } else if (type == 2) {
            // test2 logic
        }


    }


    public <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for (T t : a) {
            c.add(t);
        }
    }


}
