package com.zhiku.elearning.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.zhiku.elearning.entity.mongodb.Paragraph;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContentTemplate {
    @Autowired
    private MongoTemplate mongoTemplate;

    private List<Paragraph> getAll() {
        Query query = new Query();
        //        ListIterator<Paragraph> iter = courses.listIterator();
//        while(iter.hasNext()){
//            Paragraph c = iter.next();
//            System.out.println(c.getParagraphContent());
//            System.out.println(c.getParagraphKnowledge());
//            System.out.println(c.getClass());
//        }
        return mongoTemplate.find(query, Paragraph.class);
    }

    /**
     * 查询多个知识点的段落，有顺序
     *
     * @param kids 知识点列表
     */
    public List<Paragraph> findByKids(List<Integer> kids) {
        Query query = new Query();
        query.addCriteria(Criteria.where("paragraph_knowledge").in(kids));
        // 先按知识点id排序，再按同一知识点下的seq序号排序
        query.with(Sort.by("paragraph_knowledge", "paragraph_seq"));
        return mongoTemplate.find(query, Paragraph.class);
    }

    public void updateByPrimaryKey(Paragraph paragraph) {
        Query query = new Query();
        Update update = new Update();
        query.addCriteria(Criteria.where("_id").is(paragraph.getPid()));
        DBObject dbDoc = new BasicDBObject();
        mongoTemplate.getConverter().write(paragraph, (Bson) dbDoc);
        update = fromDBObjectExcludeNullFields(dbDoc, update);
        mongoTemplate.upsert(query, update, Paragraph.class);
    }

    public void instertAll(List<Paragraph> paragraphs) {
        if (paragraphs != null && paragraphs.size() > 0)
            mongoTemplate.insert(paragraphs, Paragraph.class);
    }

    //不为null的字段更新//不含_class
    public static Update fromDBObjectExcludeNullFields(DBObject object, Update update) {
        for (String key : object.keySet()) {
            Object value = object.get(key);
            if (value != null && !key.equals("_class")) {
                update.set(key, value);
            }
        }
        return update;
    }
}
