package com.zhiku.elearning.view;


import com.zhiku.elearning.entity.Course;

import java.util.List;

/**
 * 课程视图
 * 用来返回对应课程及其对应小节的目录
 */
public class CourseView extends Course {
    private List<SectionView> sections ;

    public List<SectionView> getSections() {
        return sections;
    }

    public void setSections(List<SectionView> sections) {
        this.sections = sections;
    }
}
