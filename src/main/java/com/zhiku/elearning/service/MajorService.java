package com.zhiku.elearning.service;

import com.zhiku.elearning.entity.mysql.Major;
import com.zhiku.elearning.mapper.MajorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 暂时用不到
 */
@Service
public class MajorService {
    @Autowired
    private MajorMapper majorMapper;

    @Deprecated
    public List<Major> getAllMajors(){
        return majorMapper.selectAllMajors();
    }
}
