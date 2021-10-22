package com.zhiku.elearning.view;


import com.zhiku.elearning.entity.mongodb.Paragraph;
import com.zhiku.elearning.entity.mysql.Knowledge;

import java.util.List;

/**
 * 知识点视图
 * 配合节视图，展示知识点下的所有内容
 */
public class KnowledgeView extends Knowledge {
    /**
     * 一个知识点下面可以有很多段落
     * 如 3.3.2 math库解析 是一个知识点，下面可能有多个段落，如图片，代码，文字解释等等
     */
    private List<Paragraph> paragraphs;


    public List<Paragraph> getParagraphs(){
        return this.paragraphs;
    }

    public void setParagraphs(List<Paragraph> paragraphs){
        this.paragraphs = paragraphs;
    }
}
