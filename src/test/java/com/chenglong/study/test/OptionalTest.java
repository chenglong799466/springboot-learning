package com.chenglong.study.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author v_longcheng
 * @date 2019/10/14
 * @description
 */
@Slf4j
public class OptionalTest {

	@Test
	public void test0() {

	}


	//@Test
	public void test() {

		Long a = 1L;
		Long b = null;

		System.out.println(a - b);


		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");

		final Optional<String> first = list.stream().filter(o -> StringUtils.equals("5", o)).findFirst();

		System.out.println("isPresent:" + first.isPresent());

		first.ifPresent(o -> {
			System.out.println("111111111");
		});


	}


}
