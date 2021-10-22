package com.zhiku.elearning.entity.mysql;


// FIXME 使用MongoDB重构，功能有com.zhiku.elearning.entity.mongodb.Paragraph 代替
// 将来可以去掉
@Deprecated
public class ParagraphMysql {
    /**
     * 自增 id
     */
    private Integer pid;

    /**
     * 段落序号,段落排序的依据
     */
    private Integer paragraphSeq;

    /**
     * 所属知识点, 参考 knowledge 的 kid
     */
    private Integer paragraphKnowledge;

    /**
     * 段落类型,标志段落的类型：
     * P 段落
     * C 代码
     * L markdown 中表示单独一行的标记语言如: + - *
     * I 图片
     * T 表格
     * t (似乎含义与 P 重复，都表示文本)
     * todo 数据库的表的DDL的comment 尚未修改
     */
    private String paragraphType;

    /**
     * 标记该段落是否要换行
     */
    private String paragraphNewline;

    /**
     * 段落内容
     */
    private String paragraphContent;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getParagraphSeq() {
        return paragraphSeq;
    }

    public void setParagraphSeq(Integer paragraphSeq) {
        this.paragraphSeq = paragraphSeq;
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

    public String getParagraphNewline() {
        return paragraphNewline;
    }

    public void setParagraphNewline(String paragraphNewline) {
        this.paragraphNewline = paragraphNewline == null ? null : paragraphNewline.trim();
    }

    public String getParagraphContent() {
        return paragraphContent;
    }

    public void setParagraphContent(String paragraphContent) {
        this.paragraphContent = paragraphContent == null ? null : paragraphContent.trim();
    }
}