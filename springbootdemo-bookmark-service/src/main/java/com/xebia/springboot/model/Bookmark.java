package com.xebia.springboot.model;

/**
 * Created by tomhofte on 31/01/2017.
 */
public class Bookmark {

    private String username;
    private String label;
    private String href;
    private String description;
    private int id;

    public Bookmark(){

    }

    public Bookmark(String username, String label, String href, String description, int id) {
        this.username = username;
        this.label = label;
        this.href = href;
        this.description = description;
        this.id = id;

    }

    public String getUsername(){ return this.username;}

    public void setUsername(String username){
        this.username = username;
    }

    public void setLabel(String label){
        this.label = label;
    }

    public String getLabel(){
        return label;
    }

    public void setDescription(){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public String getHref(){
        return href;
    }

    public void setHref(String href){
        this.href = href;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }


}
