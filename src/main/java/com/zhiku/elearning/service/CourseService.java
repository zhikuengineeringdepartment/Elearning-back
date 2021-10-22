package com.zhiku.elearning.service;

import com.zhiku.elearning.entity.Course;
import com.zhiku.elearning.entity.mysql.CollectCourse;
import com.zhiku.elearning.entity.mysql.CollectCourseKey;
import com.zhiku.elearning.view.CollectCourseView;
import com.zhiku.elearning.mapper.CollectCourseMapper;
import com.zhiku.elearning.mongo.CourseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CollectCourseMapper collectCourseMapper;
    @Autowired
    private CourseTemplate courseTemplate;

    /**
     * 获得所有课程
     *
     * @return 课程列表
     */
    public List<Course> getAllCourse() {
        return courseTemplate.getAllCourse();
    }


    /**
     * 查询收藏的课程及相关进度
     */
    @Deprecated
    public List<CollectCourseView> getColCourses(int uid) {
        return collectCourseMapper.selectColCourseView(uid);
    }

    /**
     * 添加收藏课程
     *
     * @param uid 用户id
     * @param cid 课程id
     * @return 是否收藏成功
     */
    @Deprecated
    public boolean colCourse(int uid, int cid) {
        boolean finish;
        CollectCourse colCourse = new CollectCourse();
        colCourse.setCourseId(cid);
        colCourse.setUserId(uid);
        colCourse.setDate(new Date());
        int code = collectCourseMapper.insert(colCourse);
        finish = code > 0;
        return finish;
    }

    /**
     * 删除收藏课程
     *
     * @param uid 用户id
     * @param cid 课程id
     */
    @Deprecated
    public void removeColCourse(int uid, int cid) {
        //删除所收藏的课
        CollectCourseKey collectCourseKey = new CollectCourseKey();
        collectCourseKey.setCourseId(cid);
        collectCourseKey.setUserId(uid);
        collectCourseMapper.deleteByPrimaryKey(collectCourseKey);
    }

    public List<String> getVids(Integer cid) {
        return courseTemplate.getVids(cid);
    }

}
