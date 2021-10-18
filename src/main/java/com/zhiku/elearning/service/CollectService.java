package com.zhiku.elearning.service;

import com.zhiku.elearning.entity.mongodb.ColParagraph;
import com.zhiku.elearning.entity.mongodb.Note;
import com.zhiku.elearning.mongo.CollectTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectService {
    @Autowired
    private CollectTemplate template;

    public List<ColParagraph> getAllColPara(){
        return this.template.getAllColPara();
    }
    public List<Note> getAllNote(){
        return this.template.getAllNote();
    }
}
