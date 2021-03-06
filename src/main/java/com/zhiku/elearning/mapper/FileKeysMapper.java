package com.zhiku.elearning.mapper;

import com.zhiku.elearning.entity.mysql.FileKeys;
import org.springframework.stereotype.Component;

@Component
public interface FileKeysMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(FileKeys record);

    int insertSelective(FileKeys record);

    FileKeys selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(FileKeys record);

    int updateByPrimaryKey(FileKeys record);
}