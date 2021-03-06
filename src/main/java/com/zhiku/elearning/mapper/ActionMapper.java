package com.zhiku.elearning.mapper;

import com.zhiku.elearning.entity.mysql.Action;
import org.springframework.stereotype.Component;

@Component
public interface ActionMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(Action record);

    int insertSelective(Action record);

    Action selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(Action record);

    int updateByPrimaryKeyWithBLOBs(Action record);

    int updateByPrimaryKey(Action record);
}