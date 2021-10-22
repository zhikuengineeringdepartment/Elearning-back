package com.zhiku.elearning.view;


import com.zhiku.elearning.entity.mysql.NoteMysql;

/**
 * 笔记视图
 */
public class NoteView extends NoteMysql {
    private CollectParagraphView colParagraphView;

    public void setColParagraphView(CollectParagraphView colParagraphView) {
        this.colParagraphView = colParagraphView;
    }

    public CollectParagraphView getColParagraphView() {
        return colParagraphView;
    }
}
