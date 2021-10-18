package com.zhiku.elearning.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json工具类, 功能为对象和字符串互相转换
 */
public final class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Serialize any Java value as a String.
     */
    public static String stringfy(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JsonUtil stringfy error: " + e.getMessage());
        }
    }

    /**
     * Deserialize JSON content from given JSON content String.
     */
    public static <T> T parse(String content, Class<T> valueType) {
        try {
            return mapper.readValue(content, valueType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JsonUtil parse error: " + e.getMessage());
        }
    }
}
