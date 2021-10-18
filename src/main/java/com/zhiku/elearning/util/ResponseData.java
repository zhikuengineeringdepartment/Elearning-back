package com.zhiku.elearning.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据模板
 */
public class ResponseData {
    private String message;     //附带的消息
    private int code;   //状态码
    private final Map<String, Object> data = new HashMap<String, Object>();     //附带的数据

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public void setMessage(String message){ this.message = message; }

    public void setCode(int code) { this.code = code; }

    public Map<String, Object> getData() {
        return data;
    }

    public ResponseData putDataValue(String key, Object value) {
        data.put(key, value);
        return this;
    }

    public ResponseData() {
        this.code = 200;
    }

    public ResponseData(int code, String message) {
        this.code = code;
        this.message = message;
    }

    //预设一些常用的返回
    public static ResponseData ok() {
        return new ResponseData(200, "Ok");
    }

    public static ResponseData notFound() {
        return new ResponseData(404, "Not Found");
    }

    public static ResponseData badRequest() {
        return new ResponseData(400, "Bad Request");
    }

    public static ResponseData forbidden() {
        return new ResponseData(403, "Forbidden");
    }

    public static ResponseData unauthorized() {
        return new ResponseData(401, "unauthorized");
    }

    public static ResponseData serverInternalError() {
        return new ResponseData(500, "Server Internal Error");
    }

    public static ResponseData customerError() {
        return new ResponseData(1001, "customer Error");
    }

    public static ResponseData loginError() {
        return new ResponseData(1002, "未登陆");
    }

    public static ResponseData powerError() {
        return new ResponseData(1003, "抱歉，您没有该权限！");
    }
}
