package com.zhiku.elearning.service;

import com.zhiku.elearning.entity.UserCode;
import com.zhiku.elearning.mapper.UserCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCodeService {
    @Autowired
    private UserCodeMapper userCodeMapper;

    public void saveUserCode(UserCode userCode){
        userCodeMapper.insert(userCode);
    }

    public UserCode getUserCodeById(int uid){
        return userCodeMapper.selectByPrimaryKey(uid);
    }

    public void deleteByPrimaryKey(int uid){
        userCodeMapper.deleteByPrimaryKey(uid);
    }
}
