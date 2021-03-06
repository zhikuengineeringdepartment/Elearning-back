package com.zhiku.elearning.mapper;

import com.zhiku.elearning.entity.mysql.Boardcast;
import org.springframework.stereotype.Component;

@Component
public interface BoardcastMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(Boardcast record);

    int insertSelective(Boardcast record);

    Boardcast selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Boardcast record);

    int updateByPrimaryKeyWithBLOBs(Boardcast record);

    int updateByPrimaryKey(Boardcast record);
}