package com.zhiku.elearning.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.zhiku.elearning.entity.mongodb.ColParagraph;
import com.zhiku.elearning.entity.mongodb.Note;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CollectTemplate {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<ColParagraph> getAllColPara() {
        Query query = new Query();
        //        ListIterator<ColParagraphMysql> iter = courses.listIterator();
//        while(iter.hasNext()){
//            ColParagraphMysql c = iter.next();
//            System.out.println(c.getColpPara());
//            System.out.println(c.getColpUser());
//            System.out.println(c.getClass());
//        }
        return mongoTemplate.find(query, ColParagraph.class);
    }

    public List<Note> getAllNote() {
        Query query = new Query();
        //        ListIterator<NoteMysql> iter = courses.listIterator();
//        while(iter.hasNext()){
//            NoteMysql c = iter.next();
//            System.out.println(c.getNoteContent());
//            System.out.println(c.getNoteDate());
//        }
        return mongoTemplate.find(query, Note.class);
    }

    public void updateByPrimaryKey(ColParagraph colParagraph) {
        Query query = new Query();
        Update update = new Update();
        query.addCriteria(Criteria.where("_id").is(colParagraph.getId()));
        DBObject dbDoc = new BasicDBObject();
        mongoTemplate.getConverter().write(colParagraph, (Bson) dbDoc);
        update = ContentTemplate.fromDBObjectExcludeNullFields(dbDoc, update);
        mongoTemplate.upsert(query, update, ColParagraph.class);
    }

    public boolean insertColPar(int uid, ObjectId paragraphSeq) {
        ColParagraph cp = new ColParagraph();
        cp.setColpDate(new Date());
        cp.setColpPara(paragraphSeq);
        cp.setColpUser(uid);
        mongoTemplate.insert(cp);
        return true;
    }

    public boolean removeColPar(int uid, ObjectId paragraphSeq) {
        Query query = new Query();
        query.addCriteria(new Criteria("colp_para").is(paragraphSeq).and("colp_user").is(uid));
        mongoTemplate.remove(query, ColParagraph.class);
        return true;
    }

}