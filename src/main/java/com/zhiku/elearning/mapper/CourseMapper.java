package com.zhiku.elearning.mapper;

import com.zhiku.elearning.entity.Course;
import com.zhiku.elearning.view.CourseView;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * mysql 中的 course 表已经被废弃，响应的 CourseMapper、XML等也都不再使用
 */

@Deprecated
@Component
public interface CourseMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    //自定义方法
    int insertGetId(Course record);

    List<Course> getAllCourse();

    CourseView getCourseView(Integer cid);

    Course selectByTitleDec(@Param( "title" ) String title, @Param( "describe" ) String describe);

}