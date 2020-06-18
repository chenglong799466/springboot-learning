package com.chenglong.study.test;

import com.chenglong.study.model.User;
import com.chenglong.study.utils.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;

/**
 * @author v_longcheng
 * @date 2019/6/21
 * @description
 */
@Slf4j
public class JsonUtilTest {


	@Test
	public void test() throws JsonProcessingException {

		User user = new User();

		user.setAge(11);
		user.setDate(new Date());
		user.setNickName("cchenglong");


		String s = JsonUtils.generate(user);

		log.info("sssss {}", s);


	}
}
