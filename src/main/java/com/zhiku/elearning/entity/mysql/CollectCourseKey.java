package com.zhiku.elearning.entity.mysql;

public class CollectCourseKey {

    /**
     * 收藏此课程的用户的id
     */
    private Integer userId;

    /**
     * 收藏的课程的id
     */
    private Integer courseId;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}