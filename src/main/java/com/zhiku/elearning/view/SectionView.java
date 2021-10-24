package com.zhiku.elearning.view;


import java.util.List;

/**
 * 章视图
 */
public class SectionView{
    private String title;
    private int index;
    private List<SubView> sub; // 一个章的若干节

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<SubView> getSub() {
        return sub;
    }

    public void setSub(List<SubView> sub) {
        this.sub = sub;
    }

}
