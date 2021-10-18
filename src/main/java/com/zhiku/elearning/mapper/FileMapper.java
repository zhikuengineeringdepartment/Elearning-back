package com.zhiku.elearning.mapper;

import com.zhiku.elearning.entity.User;
import com.zhiku.elearning.entity.mysql.File;
import com.zhiku.elearning.view.FileView;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface FileMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(File record);

    int insertSelective(File record);

    File selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKeyWithBLOBs(File record);

    int updateByPrimaryKey(File record);

    File selectBySha(String sha);

    int getFileNumber();

    int getAdminFileNumber(String status);

    List<FileView> selectFiles(@Param("keyWord") String keyWord, @Param("file") File file, @Param("startLine") int startLine,
                               @Param("pageSize") int pageSize, @Param("order") boolean order, @Param("status")String status, @Param("statusDelete")String statusDelete);

    List<FileView> selectFileUploadRecords(@Param("user") User user, @Param("startLine") int startLine, @Param("pageSize") int pageSize);
}