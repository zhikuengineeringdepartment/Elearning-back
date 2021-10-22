package com.zhiku.elearning.entity.mongodb;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

public class Child {
    private Integer sid;
    private Integer section_seq;
    /**
     * 分段名：如 '2.1 基本概念'
     */
    private String section_name;
    /**
     * 层级结构
     */
    private Integer level;
    private List<Document> contents; // todo 这个是什么意思？

    /**
     * 递归式的树形结构，如1级标题包含多个2级标题，2级标题包含多个3级标题
     */
    private List<Child> sub;

    public List<Document> getContents() {
        return contents;
    }

    public void setContents(List<Document> contents) {
        this.contents = contents;
    }

    public List<Child> getSub() {
        return sub;
    }

    public void setSub(List<Child> sub) {
        this.sub = sub;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Integer getSection_seq() {
        return section_seq;
    }

    public void setSection_seq(Integer section_seq) {
        this.section_seq = section_seq;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}
