package com.zhiku.elearning.mapper;

import com.zhiku.elearning.entity.mysql.Preference;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface PreferenceMapper {
    int deleteByPrimaryKey(Integer prfid);

    int insert(Preference record);

    int insertSelective(Preference record);

    Preference selectByPrimaryKey(Integer prfid);

    int updateByPrimaryKeySelective(Preference record);

    int updateByPrimaryKey(Preference record);

    //自定义方法
    List<Preference> selectAllPreferences();

}