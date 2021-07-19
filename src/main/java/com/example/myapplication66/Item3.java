package com.example.myapplication66;

public class Item3 {
    int edu_id;
    String name;
    String image;
    String goal;
    String msg;
    String url;

    public Item3(){
    }

    public Item3(int edu_id, String name, String image, String goal, String msg, String url){
        this.edu_id = edu_id;
        this.name = name;
        this.image = image;
        this.goal = goal;
        this.msg = msg;
        this.url = url;
    }

    public int getEdu_id(){
        return edu_id;
    }
    public void setEdu_id(int edu_id){
        this.edu_id = edu_id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getImage(){return image;}
    public void setImage(String image){this.image = image;}

    public String getGoal(){return goal;}
    public void setGoal(String goal){this.goal = goal;}

    public String getMsg(){
        return msg;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }

    public String getUrl(){return url;}
    public void setUrl(String url){this.url = url;}
}
