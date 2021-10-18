package com.zhiku.elearning.mapper;


import com.zhiku.elearning.entity.VerificationCode;
import org.springframework.stereotype.Component;

@Component
public interface VerificationCodeMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(VerificationCode record);

    int insertSelective(VerificationCode record);

    VerificationCode selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(VerificationCode record);

    int updateByPrimaryKey(VerificationCode record);

    //自定义方法
    //插入或更新
    int replaceSelective(VerificationCode record);

}