package com.zhiku.elearning.entity.mongodb;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("content")
public class Paragraph {
    @Id
    @Field("_id")
    private ObjectId pid;

    /**
     * 该段落所属知识点的 id
     */
    @Field("paragraph_knowledge")
    private Integer paragraphKnowledge;

    /**
     * 同一知识点下排序的依据
     */
    @Field("paragraph_seq")
    private Integer paragraphSeq;

    /**
     * 段落类型,标志段落的类型：
     * P 段落
     * C 代码
     * L markdown 中表示单独一行的标记语言如: + - *
     * I 图片
     * T 表格
     * t (似乎含义与 P 重复，都表示文本)
     */
    @Field("paragraph_type")
    private String paragraphType;

    /**
     * 段落内容
     */
    @Field("paragraph_content")
    private String paragraphContent;

    public Integer getParagraphSeq() {
        return paragraphSeq;
    }

    public void setParagraphSeq(Integer paragraphSeq) {
        this.paragraphSeq = paragraphSeq;
    }

    public ObjectId getPid() {
        return pid;
    }

    public void setPid(ObjectId pid) {
        this.pid = pid;
    }

    public Integer getParagraphKnowledge() {
        return paragraphKnowledge;
    }

    public void setParagraphKnowledge(Integer paragraphKnowledge) {
        this.paragraphKnowledge = paragraphKnowledge;
    }

    public String getParagraphType() {
        return paragraphType;
    }

    public void setParagraphType(String paragraphType) {
        this.paragraphType = paragraphType == null ? null : paragraphType.trim();
    }
    public String getParagraphContent() {
        return paragraphContent;
    }

    public void setParagraphContent(String paragraphContent) {
//        this.paragraphContent = paragraphContent == null ? null : paragraphContent.trim();
        this.paragraphContent = paragraphContent;
    }
}