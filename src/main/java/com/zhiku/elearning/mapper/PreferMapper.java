package com.zhiku.elearning.mapper;

import com.zhiku.elearning.entity.mysql.PreferKey;
import com.zhiku.elearning.view.PreferView;
import org.springframework.stereotype.Component;

@Component
public interface PreferMapper {
    int deleteByPrimaryKey(PreferKey key);

    int insert(PreferKey record);

    int insertSelective(PreferKey record);

    //自定义SQL
    PreferView selectPreferViewByUid(int uid);
}