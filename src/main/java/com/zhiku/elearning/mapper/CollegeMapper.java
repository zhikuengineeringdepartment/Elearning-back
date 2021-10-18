package com.zhiku.elearning.mapper;

import com.zhiku.elearning.entity.mysql.College;
import org.springframework.stereotype.Component;

@Component
public interface CollegeMapper {
    int deleteByPrimaryKey(Integer collegeId);

    int insert(College record);

    int insertSelective(College record);

    College selectByPrimaryKey(Integer collegeId);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);
}