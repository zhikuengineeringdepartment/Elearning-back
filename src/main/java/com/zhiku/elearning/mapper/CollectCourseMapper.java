package com.zhiku.elearning.mapper;

import com.zhiku.elearning.entity.mysql.CollectCourse;
import com.zhiku.elearning.entity.mysql.CollectCourseKey;
import com.zhiku.elearning.view.CollectCourseView;
import org.springframework.stereotype.Component;

import java.util.List;

@Deprecated
@Component
public interface CollectCourseMapper {
    int deleteByPrimaryKey(CollectCourseKey key);

    int insert(CollectCourse record);

    int insertSelective(CollectCourse record);

    CollectCourse selectByPrimaryKey(CollectCourseKey key);

    int updateByPrimaryKeySelective(CollectCourse record);

    int updateByPrimaryKey(CollectCourse record);

    //====================自定义SQL=====================================
    //根据用户id查找收藏的课程及进度
    List<CollectCourseView> selectColCourseView(Integer uid);
}