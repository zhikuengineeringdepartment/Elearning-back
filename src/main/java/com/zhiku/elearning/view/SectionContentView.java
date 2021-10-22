package com.zhiku.elearning.view;

import java.util.List;

/**
 * 节视图
 *
 */
public class SectionContentView extends SubView {

    /**
     * 一个节下面有很多知识点。
     * 如 ## 3.3 模块1：math库的使用是一节，下面有很多很多知识点，如 3.3.1 math库概述、3.3.2 math库解析 等等
     *
     */
    private List<KnowledgeView> knowledgeViews;

    public List<KnowledgeView> getKnowledgeViews() {
        return knowledgeViews;
    }

    public void setKnowledgeViews(List<KnowledgeView> knowledgeViews) {
        this.knowledgeViews = knowledgeViews;
    }


}
