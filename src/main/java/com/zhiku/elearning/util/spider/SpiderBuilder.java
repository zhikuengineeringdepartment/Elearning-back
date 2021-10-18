package com.zhiku.elearning.util.spider;



public class SpiderBuilder {
    Spider spider = new CsdnSpider();
    /**
     * 需要很多参数
     */
    public Spider getCsdnSpider(String question, String type, String page){
        spider.setUrl(question,type,page);
        spider.setInfo();
        return spider;
    }


}
