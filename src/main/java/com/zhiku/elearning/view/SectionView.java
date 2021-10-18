package com.zhiku.elearning.view;


import java.util.List;

/**
 * 节视图
 * 主要用于展示一小节的所有内容
 * 节-知识点-段落
 */
public class SectionView{
    private String title;
    private int index;
    private List<SubView> sub;

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
