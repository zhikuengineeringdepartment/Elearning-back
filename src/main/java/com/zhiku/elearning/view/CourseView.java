package com.zhiku.elearning.view;


import com.zhiku.elearning.entity.Course;

import java.util.List;

/**
 * 课程视图
 *
 */
public class CourseView extends Course {
    private List<SectionView> sections; // 一个课程的若干章

    public List<SectionView> getSections() {
        return sections;
    }

    public void setSections(List<SectionView> sections) {
        this.sections = sections;
    }
}
