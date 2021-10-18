package com.zhiku.elearning.mapper;

import com.zhiku.elearning.entity.Article;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArticleMapper {
    List<Article> getAllArticle();
}
