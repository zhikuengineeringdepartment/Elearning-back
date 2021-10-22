package com.zhiku.elearning.entity.mysql;

import java.util.Date;

public class CollectCourse extends CollectCourseKey {
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}