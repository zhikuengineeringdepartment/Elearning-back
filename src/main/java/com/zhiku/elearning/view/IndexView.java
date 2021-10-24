package com.zhiku.elearning.view;


import com.zhiku.elearning.entity.mongodb.Child;
import com.zhiku.elearning.entity.mongodb.CourseIndex;

import java.util.List;

public class IndexView {
    private List<CourseIndex> sections;
    private List<Child> children;

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<CourseIndex> getIndexList() {
        return sections;
    }

    public void setIndexList(List<CourseIndex> sections) {
        this.sections = sections;
    }

}
