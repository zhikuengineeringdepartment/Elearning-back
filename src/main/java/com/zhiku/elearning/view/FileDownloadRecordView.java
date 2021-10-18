package com.zhiku.elearning.view;


import com.zhiku.elearning.entity.mysql.Fileop;

/**
 * 文件下载记录视图
 */
public class FileDownloadRecordView extends Fileop {
    private FileView fileView;
    private String upperName;

    public FileView getFileView() {
        return fileView;
    }

    public String getUpperName() {
        return upperName;
    }

    public void setFileView(FileView fileView) {
        this.fileView = fileView;
    }

    public void setUpperName(String upperName) {
        this.upperName = upperName;
    }
}
