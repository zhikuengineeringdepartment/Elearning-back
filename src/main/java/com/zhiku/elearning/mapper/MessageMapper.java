package com.zhiku.elearning.mapper;

import com.zhiku.elearning.entity.mysql.Message;
import com.zhiku.elearning.view.MessageView;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface MessageMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKeyWithBLOBs(Message record);

    int updateByPrimaryKey(Message record);

//    自定义方法
    List<MessageView> selectMessagesByUser(Message message);
}