package com.zhiku.elearning.view;

public class SubView {
    /**
     * 节id
     */
    private Integer sid;

    /**
     * 节名
     * 如：## 2.1 基本概念
     */
    private String sectionName;

    private Integer sectionSeq;

    /**
     * 对应的课程的 cid
     */
    private Integer sectionCourse;


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Integer getSectionSeq() {
        return sectionSeq;
    }

    public void setSectionSeq(Integer sectionSeq) {
        this.sectionSeq = sectionSeq;
    }

    public Integer getSectionCourse() {
        return sectionCourse;
    }

    public void setSectionCourse(Integer sectionCourse) {
        this.sectionCourse = sectionCourse;
    }


}
