package com.zhiku.elearning.mapper;

import com.zhiku.elearning.entity.mysql.Role;
import org.springframework.stereotype.Component;

@Component
public interface RoleMapper {
    int deleteByPrimaryKey(Role key);

    int insert(Role record);

    int insertSelective(Role record);
}