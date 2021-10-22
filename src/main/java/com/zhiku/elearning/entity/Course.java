package com.zhiku.elearning.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 前端展示 [知识见解](http://sharingideas.cn/#/knowledge)
 * 数据源为 MongoDB，RDBMS 中的 course 已废弃
 *
 */

@Document(collection = "course")
public class Course {
    @Id
    private ObjectId objectId;
    @Indexed
    private Integer cid;

    /**
     * 课程名
     */
    @Field("course_name")
    private String courseName;

    /**
     * 课程描述
     */
    @Field("course_desc")
    private String courseDesc;

    /**
     * 课程图标
     */
    @Field("course_icon")
    private String courseIcon;
    @Field("vid")
    private String vid;


    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc == null ? null : courseDesc.trim();
    }

    public String getCourseIcon() {
        return courseIcon;
    }

    public void setCourseIcon(String courseIcon) {
        this.courseIcon = courseIcon == null ? null : courseIcon.trim();
    }


}