package com.zhiku.elearning.mongo;

import com.zhiku.elearning.entity.Course;
import com.zhiku.elearning.entity.mongodb.Child;
import com.zhiku.elearning.entity.mongodb.CourseIndex;
import com.zhiku.elearning.entity.mongodb.MongoSystem;
import com.zhiku.elearning.entity.mongodb.Paragraph;
import com.zhiku.elearning.util.ChildUtil;
import com.zhiku.elearning.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.*;

import static org.springframework.data.mongodb.core.query.Query.query;

@Component
public class IndexTemplate {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 获取指定课程的左栏索引（修复前端需要处理逻辑的问题）
     *
     * @param cid
     * @return courseview
     */
    // FIXME 待删除
    @Deprecated
    public CourseView getLeftIndex(int cid) {
        //查询出课程号
        Criteria classinfo = Criteria.where("cid").is(cid);
        List<Course> courses = mongoTemplate.find(query(classinfo), Course.class);
        Course course = courses.get(0);
        //查询出对应课程号的一级索引
        Criteria index = Criteria.where("cid").is(cid);
        List<CourseIndex> indexlist = mongoTemplate.find(query(index), CourseIndex.class);
        CourseIndex i = indexlist.get(0);//修改表结构之后，indexlist里应该只有一条index记录
        List<SectionView> sections = new ArrayList<SectionView>();
        List<Child> children = i.getCatalog();
        int ind = 0;
        for (Child c : children) {
            List<SubView> sub = new ArrayList<SubView>();
            SectionView sec = new SectionView();
            //获取catalog中的第一层的一个child结构
            //进行相应的处理，把数据装进SectionView里面
            sec.setTitle(c.getSection_name().substring(2, 5));
            sec.setIndex(ind);
            ind++;
            //把当前这个child的内容装进subview里，把subview装到sub里面
            SubView subView = new SubView();
            subView.setSid(c.getSid());
            subView.setSectionName(c.getSection_name());
            subView.setSectionSeq(c.getSection_seq());
            subView.setSectionCourse(cid);
            sub.add(subView);
            List<Child> children1 = c.getSub();
            //如果这个child结构下面还有嵌套的child结构，则取出第二层
            if (children1 != null) {
                for (Child c1 : children1) {
                    //进行相应的处理
                    //把当前这个child的内容装进subview里，把subview装到sub里面
                    SubView subView1 = new SubView();
                    subView1.setSid(c1.getSid());
                    subView1.setSectionName(c1.getSection_name());
                    subView1.setSectionSeq(c1.getSection_seq());
                    subView1.setSectionCourse(cid);
                    sub.add(subView1);
                }
            }
            //把sub装到sec里面
            sec.setSub(sub);
            //把sec装到sections里面
            sections.add(sec);
        }
        //System.out.println(sections);
        CourseView courseView = new CourseView();
        courseView.setSections(sections);
        courseView.setCid(course.getCid());
        courseView.setCourseName(course.getCourseName());
        courseView.setCourseDesc(course.getCourseDesc());
        courseView.setCourseIcon(course.getCourseIcon());
        return courseView;
    }

    /**
     * 获取目录
     *
     * @param cid 课程id
     * @param vid 版本号
     */
    public CourseView getLeftIndex2(int cid, String vid) {
        //查询出课程
        Criteria classInfo = Criteria.where("cid").is(cid);
        List<Course> courses = mongoTemplate.find(query(classInfo), Course.class);
        if (courses.size() == 0) {
            return null;
        }
        Course course = courses.get(0);
        if (vid == null) {//如果没有指定版本，使用课程中存放的优先版本
            vid = course.getVid();
        }
        //查询出对应课程号的一级索引

        Criteria index = Criteria.where("cid").is(cid).and("vid").is(vid);
        List<CourseIndex> courseIndexList = mongoTemplate.find(query(index), CourseIndex.class);
        if (courseIndexList.size() == 0) {
            return null;
        }
        CourseIndex i = courseIndexList.get(0);//修改表结构之后，indexList里应该只有一条index记录
        //按seq排序
        ChildUtil.childSort(i.getCatalog());

        return index2CourseView(i, course);
    }

    /**
     * 获取目录，仅章、节部分
     *
     * @param cid 课程id
     * @param vid 版本号
     */
    public CourseIndex getCatalog(int cid, String vid) {
        //查询出对应课程号的一级索引
        Query query = new Query();
        query.addCriteria(Criteria.where("cid").is(cid).and("vid").is(vid));
        query.fields().exclude("catalog.sub.sub");//不包含第三层知识点
        return mongoTemplate.findOne(query, CourseIndex.class);
    }

    /**
     * 获取指定节的全部内容
     *
     * @param sid
     * @return
     */
    // fixme 待删除
    @Deprecated
    public SectionContentView getSectionContent(int sid) {
        int cid = Integer.parseInt(Integer.toString(sid).substring(0, 3));
        Criteria sectioninfo = Criteria.where("cid").is(cid);
        List<CourseIndex> indexlist = mongoTemplate.find(query(sectioninfo), CourseIndex.class);
        CourseIndex i = indexlist.get(0);//修改表结构之后，indexlist里应该只有一条index记录
        //在这条index记录里查找需要的节
        List<Child> children = i.getCatalog();
        ListIterator<Child> iter = children.listIterator();
        Child deschild = iter.next();
        if (iter.hasNext()) {
            do {
                deschild = iter.next();
            }
            while (iter.hasNext() && deschild.getSid() != sid);
        }
        //这时候deschild就是目标节
        //设置好需要的变量
        SectionContentView sectionContentView = new SectionContentView();
        List<KnowledgeView> knowledgeViews = new ArrayList<>();
        //对deschild进行处理
        sectionContentView.setSid(deschild.getSid());
        sectionContentView.setSectionName(deschild.getSection_name());
        sectionContentView.setSectionSeq(deschild.getSection_seq());
        sectionContentView.setSectionCourse(cid);

        List<Child> children1 = deschild.getSub();
        if (children1 != null) {
            for (Child c1 : children1) {
                List<Child> children2 = c1.getSub();
                if (children2 != null) {
                    for (Child c2 : children2) {
                        KnowledgeView knowledgeView = new KnowledgeView();
                        knowledgeView.setKid(c2.getSid());
//                        knowledgeView.setKnowledgeSeq(c2.getSection_seq());
                        knowledgeView.setKnowledgeName(c2.getSection_name());
//                        knowledgeView.setKnowledgeSection(c1.getSid());
                        //查找content表，找到本节对应的所有段落
                        Criteria paragraphinfo = Criteria.where("paragraph_knowledge").is(c2.getSid());
                        List<Paragraph> paragraphs = mongoTemplate.find(query(paragraphinfo), Paragraph.class);
                        knowledgeView.setParagraphs(paragraphs);

                        //把knowledgeView装到knowledgeViews里面
                        knowledgeViews.add(knowledgeView);
                    }
                }
            }
        }
        sectionContentView.setKnowledgeViews(knowledgeViews);
        return sectionContentView;
    }


    /**
     * 获取指定节的全部内容
     *
     * @param sid 对应level=2的节的id
     *            注：只查level=2的节只适用于数据库[章->节->知识点]格式严格的情况
     * @return 返回Index, 其目录下第一层，第一个是目标节
     * from jsy
     */
    public Child getSectionIndexBySid(Integer sid) {
        //查询节知识点索引结构
        CourseIndex courseIndex;
        courseIndex = mongoTemplate.findOne(Query.query(Criteria.where("catalog.sub.sid").is(sid)), CourseIndex.class);
        if (courseIndex == null)
            return null;

        //在这条index记录里查找需要的节
        Child desChild = null;
        List<Child> chapters = courseIndex.getCatalog();// 章列表
        out:for (Child chapter : chapters) {
            List<Child> sections = chapter.getSub();// 节列表
            for (Child sec : sections) {
                if (sec.getSid().equals(sid)) { //！都是Integer类型，是对象，不能直接用==比较，否则会比较地址是否相同
                    desChild = sec;
                    break out;
                }
            }
        }
        return desChild;
    }



    /**
     * 获取指定节的全部内容
     *
     * @param sid 对应level=2的节的id
     *            注：只查level=2的节只适用于数据库[章->节->知识点]格式严格的情况
     * @return 返回Index, 其目录下第一层，第一个是目标节
     */
    @Deprecated
    public CourseIndex getSectionIndexBySid(Integer sid, Integer cid, String vid) {
        //查询节知识点索引结构
        CourseIndex courseIndex;

        Query query = new Query();
        // todo 目前cid,vid 必为null（因为前端尚未传入）
        if (cid == null || vid == null) {
            query.addCriteria(Criteria.where("catalog.sub.sid").is(sid));

        } else { //有课程和版本号查询更快
            query.addCriteria(Criteria.where("cid").is(cid).and("vid").is(vid));
        }

        courseIndex = mongoTemplate.findOne(query, CourseIndex.class);

        if (courseIndex == null)
            return null;

        //在这条index记录里查找需要的节
        Child desChild = null;
        List<Child> chapters = courseIndex.getCatalog();// 章列表

        out:for (Child chapter : chapters) {
            List<Child> sections = chapter.getSub();// 节列表
            for (Child sec : sections) {
                if (sec.getSid().equals(sid)) { //！都是Integer类型，是对象，不能直接用==比较，否则会比较地址是否相同
                    desChild = sec;
                    break out;
                }
            }
        }

        // 这时候desChild就是目标节
        if (desChild == null || !desChild.getSid().equals(sid)) {
            return null;
        }
        chapters.clear();
        chapters.add(desChild);
        return courseIndex;
    }

    public CourseIndex findByPrimaryKey(Integer cid, String vid) {
        Query query = new Query();
        query.addCriteria(Criteria.where("cid").is(cid).and("vid").is(vid));
        return mongoTemplate.findOne(query, CourseIndex.class);
    }

    //更新或插入目录索引，新加入的自动赋值sid//新加入的节和知识点id均为负
    public Map<Integer, Integer> upset(CourseIndex courseIndex) {
        int sumSid = 0;
        for (Child child : courseIndex.getCatalog()) {
            sumSid += countSid(child);
        }
        //查询最大sid,并自增sumSid
        Update update = new Update().inc("max_sid", sumSid);
        Query query = new Query();
        MongoSystem mongoSystem = mongoTemplate.findAndModify(query, update, MongoSystem.class);
        int xsid = mongoSystem.getMaxSid();
        Map<Integer, Integer> kid2xkid = new HashMap<>();
        //赋值sid
        for (Child child : courseIndex.getCatalog()) {
            xsid = handleChild(child, xsid, kid2xkid);
        }
        //插入新节
        query.addCriteria(Criteria.where("cid").is(courseIndex.getCid()).and("vid").is(courseIndex.getVid()));
        Update update1 = new Update();
        update1.set("cid", courseIndex.getCid());
        update1.set("vid", courseIndex.getVid());
        update1.set("catalog", courseIndex.getCatalog());
        mongoTemplate.upsert(query, update1, CourseIndex.class);

        return kid2xkid;
    }

    public void deleteByPrimaryKey(Integer cid, String vid) {
        Query query = new Query();
        query.addCriteria(Criteria.where("cid").is(cid).and("vid").is(vid));
        mongoTemplate.remove(query, CourseIndex.class);
    }

    //给新加入的章、节、知识点附id
    private int handleChild(Child child, int xsid, Map<Integer, Integer> kid2xkid) {
        if (child.getSid() == null || child.getSid() <= 0) {
            xsid += 1;
            if (child.getLevel() == 3) {//如果是知识点保存新id
                kid2xkid.put(child.getSid(), xsid);
            }
            child.setSid(xsid);
        }

        List<Child> childList = child.getSub();
        if (childList != null && childList.size() > 0) {
            for (Child child1 : childList) {
                xsid = handleChild(child1, xsid, kid2xkid);
            }
        }
        return xsid;
    }

    //记新加入的章、节、知识点数目
    private int countSid(Child child) {
        int sum = 1;
        List<Child> childList = child.getSub();
        if (childList != null && childList.size() > 0) {
            for (Child child1 : childList) {
                if (child1.getSid() == null || child1.getSid() <= 0) {
                    sum += countSid(child1);
                }
            }
        }
        return sum;
    }

    public static CourseView index2CourseView(CourseIndex courseIndex, Course course) {
        List<SectionView> sections = new ArrayList<SectionView>();
        List<Child> children = courseIndex.getCatalog();
        int ind = 0;
        for (Child c : children) {
            List<SubView> sub = new ArrayList<SubView>();
            SectionView sec = new SectionView();
            //获取catalog中的第一层的一个child结构
            //进行相应的处理，把数据装进SectionView里面
            String title = c.getSection_name();
            if (title.indexOf("# ") == 0) {//去除章前"# "
                title = title.substring(2);
            }
            sec.setTitle(title);
            sec.setIndex(ind);
            ind++;
            List<Child> children1 = c.getSub();
            //如果这个child结构下面还有嵌套的child结构，则取出第二层
            if (children1 != null) {
                for (Child c1 : children1) {
                    //进行相应的处理
                    //把当前这个child的内容装进subview里，把subview装到sub里面
                    SubView subView1 = new SubView();
                    subView1.setSid(c1.getSid());
                    subView1.setSectionName(c1.getSection_name());
                    subView1.setSectionSeq(c1.getSection_seq());
                    subView1.setSectionCourse(course.getCid());
                    sub.add(subView1);
                }
            }
            //把sub装到sec里面
            sec.setSub(sub);
            //把sec装到sections里面
            sections.add(sec);
        }
        //System.out.println(sections);
        CourseView courseView = new CourseView();
        courseView.setSections(sections);
        courseView.setCid(course.getCid());
        courseView.setVid(course.getVid());
        courseView.setCourseName(course.getCourseName());
        courseView.setCourseDesc(course.getCourseDesc());
        courseView.setCourseIcon(course.getCourseIcon());
        return courseView;
    }

}

