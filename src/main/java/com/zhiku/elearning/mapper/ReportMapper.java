package com.zhiku.elearning.mapper;

import com.zhiku.elearning.entity.mysql.Report;
import org.springframework.stereotype.Component;

@Component
public interface ReportMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Report record);

    int insertSelective(Report record);

    Report selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Report record);

    int updateByPrimaryKeyWithBLOBs(Report record);

    int updateByPrimaryKey(Report record);
}