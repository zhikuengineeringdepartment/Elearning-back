package com.zhiku.elearning.mapper;

import com.zhiku.elearning.entity.mysql.CollectParagraphKey;
import com.zhiku.elearning.entity.mysql.CollectParagraphMysql;
import com.zhiku.elearning.view.CollectParagraphSectionView;
import com.zhiku.elearning.view.CollectParagraphView;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface CollectParagraphMapper {
    int deleteByPrimaryKey(CollectParagraphKey key);

    int insert(CollectParagraphMysql record);

    int insertSelective(CollectParagraphMysql record);

    CollectParagraphMysql selectByPrimaryKey(CollectParagraphKey key);

    int updateByPrimaryKeySelective(CollectParagraphMysql record);

    int updateByPrimaryKey(CollectParagraphMysql record);

    List<CollectParagraphSectionView> selectBySid(@Param("uid") int uid, @Param("sid") int sid);

    List<CollectParagraphView> selectParagraphView(int uid);

    /**
     * 按条件查询
     * @param uid 用户id
     * @param cid 课程id  =null表示不限制课程
     * @param ordtime 按时间排序，<0升序，=0不排序，>0降序
     * @param page 页偏移量 ==null不分页
     * @param pagesize 读取行数 ==null不分页
     */
    List<CollectParagraphView> selectParagraphViewByWhere(@Param("uid") Integer uid, @Param("cid") Integer cid, @Param("ordtime")Integer ordtime,
                                                          @Param("page")Integer page, @Param("pagesize")Integer pagesize);
}