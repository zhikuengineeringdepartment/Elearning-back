package com.zhiku.elearning.entity.mysql;


/**
 * fixme 此实体类和mysql中的 knowledge表的功能已被废弃
 */

@Deprecated
public class Knowledge {
    /**
     * 自增点 id
     */
    private Integer kid;

    /**
     * 知识点序号,对应三级标题的序号，CCC+SS+KK生成，作为排序的依据
     */
    private Integer knowledgeSeq;

    /**
     * 知识点名称，如： ### 1.1.1.本章概述
     */
    private String knowledgeName;

    /**
     * FIXME 该字段对应mysql中knowledge的字段
     * 所属小节,对应节id
     */
    @Deprecated
    private Integer knowledgeSection;

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public Integer getKnowledgeSeq() {
        return knowledgeSeq;
    }

    public void setKnowledgeSeq(Integer knowledgeSeq) {
        this.knowledgeSeq = knowledgeSeq;
    }

    public String getKnowledgeName() {
        return knowledgeName;
    }

    public void setKnowledgeName(String knowledgeName) {
        this.knowledgeName = knowledgeName == null ? null : knowledgeName.trim();
    }

    public Integer getKnowledgeSection() {
        return knowledgeSection;
    }

    public void setKnowledgeSection(Integer knowledgeSection) {
        this.knowledgeSection = knowledgeSection;
    }
}