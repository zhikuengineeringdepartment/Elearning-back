package com.zhiku.elearning.controller;

import com.zhiku.elearning.entity.User;
import com.zhiku.elearning.service.PictureService;
import com.zhiku.elearning.service.UserService;
import com.zhiku.elearning.util.ResponseData;
import com.zhiku.elearning.view.PictureView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(value = "*")
@Controller
@RequestMapping(value = "/picture")
public class PictureController {
    @Autowired
    UserService userService;

    @Autowired
    PictureService pictureService;
    /**
     * 大事年记列表获取
     * @param page 分页-页码
     * @param pageSize 分页-页每页大小
     */
    @RequestMapping(value = "/chronology/list")
    @ResponseBody
    public ResponseData chronologyList(@RequestParam(required = false) Integer page
            , @RequestParam(required = false) Integer pageSize) {
        //临时大事年记表示：用改uid上传的图片为大事年记图
        int chronologyUid = -100;
        List<PictureView> pictures=pictureService.getList(chronologyUid,page,pageSize );

        Map<String,Object>[] re=new Map[pictures.size()];
        int i=-1;
        //拼接url前地址
        for (PictureView pictureView:pictures) {
            Map<String,Object> map=new HashMap<>(  );
            map.put( "url",".."+pictureView.getUrl(  ) );
            map.put( "date",pictureView.getCreateTime( ) );
            re[++i]=map;
        }

        ResponseData responseData=new ResponseData(  );
        responseData.putDataValue( "pictures",re );
        return responseData;
    }

    //判断是否是管理员
    private boolean isAdm(User user0,String uri){
        User user = userService.getUserById(user0.getUid());
        return userService.checkAuthority( user,uri );
    }

}
