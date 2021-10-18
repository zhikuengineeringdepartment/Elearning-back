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
    @Field("paragraph_seq")
    private Integer paragraphSeq;
    @Field("paragraph_knowledge")
    private Integer paragraphKnowledge;
    @Field("paragraph_type")
    private String paragraphType;
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