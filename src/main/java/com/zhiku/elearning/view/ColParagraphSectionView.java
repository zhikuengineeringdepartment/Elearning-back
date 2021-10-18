package com.zhiku.elearning.view;


import com.zhiku.elearning.entity.mysql.ColParagraphMysql;

public class ColParagraphSectionView extends ColParagraphMysql {
    private Integer paragraphSeq;

    public Integer getParagraphSeq(){
        return this.paragraphSeq;
    }

    public void setParagraphSeq(Integer paragraphSeq){
        this.paragraphSeq = paragraphSeq;
    }
}
