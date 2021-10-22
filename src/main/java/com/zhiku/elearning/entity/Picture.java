package com.zhiku.elearning.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 *
 * 图片存储（目前存放在系统文件系统） /pictures/xxx...
 *
 */

public class Picture {
    private Integer picId;
    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 原文件名
     */
    private String orgName;

    /**
     * 课程id
     */
    private Integer cid;


    /**
     * 章节索引字符串数组
     */
    private String sections;

    /**
     * url
     */
    private String url;

    /**
     * todo 目前都为空,备份url,上传到其他图床中
     */
    private String bupUrl;

    /**
     * 创建时间
     */
    private Date createTime;

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getSections() {
        return sections;
    }

    public void setSections(String sections) {
        this.sections = sections == null ? null : sections.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getBupUrl() {
        return bupUrl;
    }

    public void setBupUrl(String bupUrl) {
        this.bupUrl = bupUrl == null ? null : bupUrl.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")//无效
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}