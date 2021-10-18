package com.zhiku.elearning.util.md2Database;

public class TempParagraph {
    public int id;
    private char type;
    private String content;
    public TempParagraph(int id, char type, String content){
        this.id=id;
        this.content=content;
        this.type=type;
    }
    public char getType(){
        return type;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String str){
        this.content=str;
    }
}
