package com.zhiku.elearning.util;

/**
 * 文件状态枚举类
 */
public enum FileStatus {
    NORMAL("n","已通过"),DUPLICATE("d","文件已存在"),TOO_LARGE("l","文件过大"),TYPE_ERROR("te","文件类型错误"),
    FILE_ERROR("fe","上传文件受损"),FORBIDDEN("f","文件被封禁"),UNCHECK("u","待审核"),
    DELETE("x","已删除");
    private final String code;  //文件状态码
    private final String name;  //文件状态描述

    private FileStatus(String code,String name){
        this.code = code;
        this.name = name;
    }

    public String getCode(){ return this.code; }
    public String getName(){
        return this.name;
    }

    public static String getName(String code) {
        for (FileStatus c : FileStatus.values()) {
            if (c.getCode().equals( code )) {
                return c.name;
            }
        }
        return null;
    }
}
