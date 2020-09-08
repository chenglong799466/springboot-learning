package com.chenglong.study.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author v_longcheng
 * @date 2019/6/21
 * @description
 */
public class JsonUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * Serialize any Java value as a String
     *
     * @param o
     * @return
     * @throws JsonProcessingException
     */
    public static String generate(Object o) throws JsonProcessingException {
        return mapper.writeValueAsString(o);
    }

    public static <T> T parse(String content, Class<T> valueType) throws IOException {
        return mapper.readValue(content, valueType);

    }


}
