package com.zhiku.elearning.mapper;

import com.zhiku.elearning.entity.mysql.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserRoleMapper {
    int deleteByPrimaryKey(UserRole key);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    String check(@Param( "uid" ) Integer uid, @Param( "uri" ) String uri);
}