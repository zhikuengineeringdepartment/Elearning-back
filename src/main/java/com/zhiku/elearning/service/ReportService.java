package com.zhiku.elearning.service;

import com.zhiku.elearning.entity.mysql.Report;
import com.zhiku.elearning.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Autowired
    private ReportMapper reportMapper;

    public void add(Report report){
        reportMapper.insertSelective( report );
    }
}
