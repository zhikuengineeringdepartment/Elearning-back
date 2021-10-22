package com.zhiku.elearning.view;


import com.zhiku.elearning.entity.mysql.CollectParagraphMysql;

public class CollectParagraphSectionView extends CollectParagraphMysql {
    private Integer paragraphSeq;

    public Integer getParagraphSeq(){
        return this.paragraphSeq;
    }

    public void setParagraphSeq(Integer paragraphSeq){
        this.paragraphSeq = paragraphSeq;
    }
}
