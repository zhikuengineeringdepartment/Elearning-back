package com.zhiku.elearning.view;


import com.zhiku.elearning.entity.mongodb.Child;
import com.zhiku.elearning.entity.mongodb.Index;

import java.util.List;

public class IndexView {
    private List<Index> sections;
    private List<Child> children;

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Index> getIndexList() {
        return sections;
    }

    public void setIndexList(List<Index> sections) {
        this.sections = sections;
    }

}
