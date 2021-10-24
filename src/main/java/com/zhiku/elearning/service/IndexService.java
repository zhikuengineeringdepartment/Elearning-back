package com.zhiku.elearning.service;

import com.zhiku.elearning.entity.mongodb.Child;
import com.zhiku.elearning.entity.mongodb.Paragraph;
import com.zhiku.elearning.util.ChildUtil;
import com.zhiku.elearning.view.CourseView;
import com.zhiku.elearning.view.KnowledgeView;
import com.zhiku.elearning.view.SectionContentView;
import com.zhiku.elearning.mongo.ContentTemplate;
import com.zhiku.elearning.mongo.IndexTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndexService {
    @Autowired
    private IndexTemplate indexTemplate;
    @Autowired
    private ContentTemplate contentTemplate;

    public CourseView getLeftIndex(int cid, String vid) {
        return indexTemplate.getLeftIndex2(cid, vid);
    }

    /**
     *
     * @param sid 节id
     *
     */
    public SectionContentView getSecondLevelIndex(int sid) {

        Child section = indexTemplate.getSectionIndexBySid(sid);
        //设置好需要的变量
        SectionContentView sectionContentView = new SectionContentView();
        sectionContentView.setSid(section.getSid());
        sectionContentView.setSectionName(section.getSection_name());
        sectionContentView.setSectionSeq(section.getSection_seq());

        List<Child> knowledgeList = section.getSub();//知识点列表
        if (knowledgeList == null || knowledgeList.isEmpty()) {
            return sectionContentView;
        }

        ChildUtil.childSort(knowledgeList);

        List<Integer> kids = new ArrayList<>(); // 所有知识点对应的id
        for (Child knowledge : knowledgeList) {
            kids.add(knowledge.getSid());
        }
        // 查询所有知识点的所有段落，段落按kid、seq降序排序 (一个知识点有多个段落)
        List<Paragraph> paragraphs = contentTemplate.findByKids(kids);

        // 键为知识点id,值为返回给前端的知识点view
        Map<Integer, KnowledgeView> knowledgeViewMap = new HashMap<>(knowledgeList.size() * 3 / 2);

        List<KnowledgeView> knowledgeViews = new ArrayList<>();
        for (Child knowledge : knowledgeList) {
            KnowledgeView knowledgeView = new KnowledgeView();
            knowledgeView.setKid(knowledge.getSid());

            knowledgeView.setKnowledgeName(knowledge.getSection_name());
            //把knowledgeView装到knowledgeViews里面

            knowledgeView.setParagraphs(new ArrayList<>());

            knowledgeViews.add(knowledgeView);
            knowledgeViewMap.put(knowledgeView.getKid(), knowledgeView);
        }

        //段落seq已按顺序排序好了
        for (Paragraph paragraph : paragraphs) {
            KnowledgeView knowledgeView = knowledgeViewMap.get(paragraph.getParagraphKnowledge());
            if (knowledgeView != null) {
                knowledgeView.getParagraphs().add(paragraph);
            }
        }

        sectionContentView.setKnowledgeViews(knowledgeViews);
        return sectionContentView;
    }

}
