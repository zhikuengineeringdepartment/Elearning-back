package com.zhiku.elearning.view;


import com.zhiku.elearning.entity.mysql.Message;

/**
 * 消息视图
 */
public class MessageView extends Message {
    private String toUserName;
    private String toAvatar;
    private String fromUserName;
    private String fromAvatar;

    public String getToUserName() {
        return toUserName;
    }

    public String getToAvatar() {
        return toAvatar;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public String getFromAvatar() {
        return fromAvatar;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public void setToAvatar(String toAvatar) {
        this.toAvatar = toAvatar;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public void setFromAvatar(String fromAvatar) {
        this.fromAvatar = fromAvatar;
    }
}
