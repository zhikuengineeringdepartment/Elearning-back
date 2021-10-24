package com.zhiku.elearning.entity.mongodb;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.List;

/*
 *
 * 返回知识见解的侧边栏索引
 *
 * 结构：
 * {
 *   "_id": {"$oid": "5de236efa5345a6ad7a51ae6"},
 *   "catalog": [
 *     {
 *       "sid": 1004,
 *       "section_seq": "2",
 *       "section_name": "# 第二章 面向对象的基本概念和程序设计",
 *       "level": 1,
 *       "contents": [],
 *       "sub": [
 *         {
 *           "sid": 1005,
 *           "section_seq": "0",
 *           "section_name": "# 第二章 面向对象的基本概念和程序设计",
 *           "level": 2,
 *           "contents": [],
 *           "sub": [
 *             {
 *               "sid": 1006,
 *               "section_seq": "1",
 *               "section_name": "### 本章概述",
 *               "level": 3,
 *               "sub": []
 *             },
 *             {},
 *             {}
 *           ]
 *         },
 *         {},
 *         {}
 *       ]
 *     },
 *     {},
 *     {}
 *   ],
 *   "cid": 112,
 *   "vid": "V1.0"
 * }
 */


/**
 *  fixme mongoDB 中的 index 文档集合应该是没有被使用的
 */

@Document(collection = "myindex")
public class CourseIndex {
    /**
     * 课程id 参考 course的 cid
     */
    @Indexed
    private Integer cid;

    /**
     * 版本 id
     */
    @Field("vid")
    private String vid;


    @Field("catalog")
    private List<Child> catalog;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public List<Child> getCatalog() {
        return catalog;
    }

    public void setCatalog(List<Child> child) {
        this.catalog = child;
    }


    @Override
    public String toString() {
        return "Index{" +
                "cid=" + cid +
                ", vid='" + vid + '\'' +
                ", catalog=" + catalog +
                '}';
    }
}
