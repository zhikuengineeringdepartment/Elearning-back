package com.zhiku.elearning.view;


import com.zhiku.elearning.entity.mysql.File;
import com.zhiku.elearning.entity.mysql.FileKeys;

/**
 * 文件视图
 */
public class FileView extends File {
    private String upperName;

    private FileKeys fileKeys;

    public String getUpperName() {
        return upperName;
    }

    public void setUpperName(String upperName) {
        this.upperName = upperName;
    }

    public FileKeys getFileKeys() {
        return fileKeys;
    }

    public void setFileKeys(FileKeys fileKeys) {
        this.fileKeys = fileKeys;
    }
}
