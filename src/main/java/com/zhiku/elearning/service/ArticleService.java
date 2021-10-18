package com.zhiku.elearning.service;

import com.zhiku.elearning.entity.Article;
import com.zhiku.elearning.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 获取所有课程，返回list
     */
    public List<Article> getAllArticle(){
        return articleMapper.getAllArticle();
    }
}
