package com.zhiku.elearning.mapper;

import com.zhiku.elearning.entity.mysql.Schedule;
import com.zhiku.elearning.entity.mysql.ScheduleKey;
import org.springframework.stereotype.Component;

@Component
public interface ScheduleMapper {
    int deleteByPrimaryKey(ScheduleKey key);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(ScheduleKey key);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);
}