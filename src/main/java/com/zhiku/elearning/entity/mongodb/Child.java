package com.zhiku.elearning.entity.mongodb;


import java.util.List;

public class Child {
    /**
     * 这个 sid 具有多态性，既有可能指"节"的id，也可能指"知识点"的id
     */
    private Integer sid;
    /**
     * 排序的序号（因为展示给前端的时候是有一定顺序的），作用域为同一sub中保持递增
     */
    private Integer section_seq;
    /**
     * 分段名：如 '2.1 基本概念'
     */
    private String section_name;
    /**
     * 层级结构
     */
    private Integer level;

    /**
     * 递归式的树形结构，如1级标题包含多个2级标题，2级标题包含多个3级标题
     */
    private List<Child> sub;


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

    @Override
    public String toString() {
        return "Child{" +
                "sid=" + sid +
                ", section_seq=" + section_seq +
                ", section_name='" + section_name + '\'' +
                ", level=" + level +
                ", sub=" + sub +
                '}';
    }
}
