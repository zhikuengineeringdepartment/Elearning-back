package com.zhiku.elearning.controller;


import com.zhiku.elearning.entity.mysql.SpecialColumnArticle;
import com.zhiku.elearning.service.SpecialColumnArticleService;
import com.zhiku.elearning.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@Controller
@RequestMapping(value = "/specialColumnArticle")
public class SpecialColumnArticleController {

    @Autowired
    private SpecialColumnArticleService specialColumnArticleService;


    /**
     * 该方法用于前台使用用户获取所有的专栏文章(不包括删除的)
     *
     */
    @ResponseBody
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public ResponseData getAllSpecialColumnArticle(Integer start, Integer size) {
        ResponseData responseData;
        SpecialColumnArticle specialColumnArticle = new SpecialColumnArticle();
        specialColumnArticle.setIsDelete(0);
        try {
            List<SpecialColumnArticle> specialColumnArticleList = specialColumnArticleService.list(specialColumnArticle, start, size);
            int total = specialColumnArticleService.getTotal(specialColumnArticle);
            responseData = ResponseData.ok();
            responseData.putDataValue("specialColumnArticleList", specialColumnArticleList);
            responseData.putDataValue("total", total);
        } catch (Exception e) {
            responseData = ResponseData.serverInternalError();
            responseData.setMessage("执行异常");
            e.printStackTrace();
        }
        return responseData;
    }

    /**
     * 该方法用于前台使用用户获取所有的专栏文章(不包括删除的)
     *
     */
    @ResponseBody
    @RequestMapping(value = "getAllByType", method = RequestMethod.GET)
    public ResponseData getAllSpecialColumnArticleByType(@RequestParam(value = "specialColumnId") Integer specialColumnId, Integer start, Integer size) {
        ResponseData responseData;
        SpecialColumnArticle specialColumnArticle = new SpecialColumnArticle();
        specialColumnArticle.setIsDelete(0); // 未删除
        specialColumnArticle.setSpecialColumnId(specialColumnId); // 文章类型

        try {
            List<SpecialColumnArticle> specialColumnArticleList = specialColumnArticleService.list(specialColumnArticle, start, size);
            int total = specialColumnArticleService.getTotal(specialColumnArticle);
            responseData = ResponseData.ok();
            responseData.putDataValue("specialColumns", specialColumnArticleList);
            responseData.putDataValue("total", total);
        } catch (Exception e) {
            responseData = ResponseData.serverInternalError();
            responseData.setMessage("执行异常");
            e.printStackTrace();
        }
        return responseData;
    }
}
