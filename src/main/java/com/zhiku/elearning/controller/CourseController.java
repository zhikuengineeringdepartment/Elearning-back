/*
关于课程的所以请求
 */
package com.zhiku.elearning.controller;

import com.zhiku.elearning.entity.Course;
import com.zhiku.elearning.service.CourseService;
import com.zhiku.elearning.service.IndexService;
import com.zhiku.elearning.service.SectionService;
import com.zhiku.elearning.util.ResponseData;
import com.zhiku.elearning.view.CourseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(value = "*")
@Controller
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private SectionService sectionService;
    @Autowired
    private IndexService indexService;

    //TODO 获得全部课程，在讨论完学院专业课程关系及表的设计之后可以考虑修改获得课程的逻辑，采用学院-专业-课程这样多级选择器

    /**
     * 获得所有的课
     * 后期修改为可按照专业搜课
     *
     * @return 课程列表
     */
    @ResponseBody
    @RequestMapping(value = "getAllCourse", method = RequestMethod.GET)
    public ResponseData getAllCourse() {
        ResponseData responseData = ResponseData.ok();
        List<Course> courses = courseService.getAllCourse();
        responseData.putDataValue("courses", courses);
        return responseData;
    }

    /**
     * 获得一个课程的目录结构
     *
     * @param cid 课程id
     * @return 课程视图（包含了目录结构）
     */
    @ResponseBody
    @RequestMapping(value = "getCourseDetails", method = RequestMethod.GET)
    public ResponseData getCourseDetails(@RequestParam(value = "cid") int cid, @RequestParam(required = false) String vid) {
        ResponseData responseData = ResponseData.ok();
        CourseView courseView = indexService.getLeftIndex(cid, vid);
        responseData.putDataValue("courseView", courseView);
        return responseData;
    }

    /**
     * 获得课程全部版本号
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getVids")
    public ResponseData getVids(Integer cid) {
        List<String> vids = courseService.getVids(cid);
        if (vids == null)
            vids = new ArrayList<>();
        ResponseData re = new ResponseData();
        re.putDataValue("vids", vids);
        return re;
    }
}
