package com.zhiku.elearning.service;

import com.zhiku.elearning.entity.mongodb.Child;
import com.zhiku.elearning.entity.mysql.Section;
import com.zhiku.elearning.view.SectionView;
import com.zhiku.elearning.mapper.SectionMapper;
import com.zhiku.elearning.mongo.IndexTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SectionService {
    @Autowired
    private SectionMapper sectionMapper;

    @Autowired
    private IndexTemplate indexTemplate;

    //获得节
    public Section getSection(int sid){
        return sectionMapper.selectByPrimaryKey(sid);
    }

    //获得节视图（节-知识点-段落）
    public SectionView getSectionView(int sid){
        return sectionMapper.getSectionViewBySid(sid);
    }

    //TODO 删除该方法，原先是用来获得课程第一个小节的，后来被遗弃
    @Deprecated
    public SectionView getIntroduce(int cid){

        return getSectionView(cid*100 + 1);
    }


    public Child getLevel2Section(Integer cid, String vid, Integer sid){
        return indexTemplate.getSectionIndexBySid(sid);
    }

}
