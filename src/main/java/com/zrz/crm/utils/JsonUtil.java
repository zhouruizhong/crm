package com.zrz.crm.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * JSON转换工具
 *
 * @author qcdl
 * @since 2019/6/5
 */
public class JsonUtil {
    private final static JsonUtil INSTANCE = new JsonUtil();

    /**
     * ObjectMapper
     */
    private ObjectMapper mapper = new ObjectMapper();

    private JsonUtil() {
    }

    public static JsonUtil getInstance() {
        return INSTANCE;
    }

    /**
     * 将map对象转换为实体对象
     *
     * @param jsonMap   jsonMap
     * @param valueType 对象类型
     * @param <T>       泛型对象
     * @return 实体对象
     */
    public <T> T toJsonObj(Map jsonMap, Class<T> valueType) {
        return toJsonObj(toJsonString(jsonMap), valueType);
    }

    /**
     * 将json字符串转换为对象
     *
     * @param jsonString json字符串
     * @param valueType  对象类型
     * @param <T>        泛型对象
     * @return 对象
     */
    public <T> T toJsonObj(String jsonString, Class<T> valueType) {
        try {
            return mapper.readValue(jsonString, valueType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将对象转换为json字符串
     *
     * @param obj 对象
     * @return json字符串
     */
    public String toJsonString(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<?> toJsonObjList(String jsonString, Class<?> valueType) {
        JavaType javaType = getCollectionType(ArrayList.class, valueType);
        try {
            return mapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
