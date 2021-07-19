package com.example.myapplication66;

public class Item {
    int work_id;
    String ins;
    String name;
    String sort;
    String tel;
    String num;
    String msg;

    public Item(){
    }

    public Item(int work_id, String ins, String name, String sort, String tel, String num, String msg){
        this.work_id = work_id;
        this.ins = ins;
        this.name = name;
        this.sort = sort;
        this.tel = tel;
        this.num = num;
        this.msg = msg;
    }

    public int getWork_id(){
        return work_id;
    }
    public void setWork_id(int work_id){
        this.work_id = work_id;
    }
    public String getIns(){
        return ins;
    }
    public void setIns(String ins){
        this.ins = ins;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSort(){
        return sort;
    }
    public void setSort(String sort){
        this.sort = sort;
    }
    public String getTel(){
        return tel;
    }
    public void setTel(String tel){
        this.tel = tel;
    }

    public String getNum(){
        return num;
    }
    public void setNum(String num){
        this.num = num;
    }

    public String getMsg(){
        return msg;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
}
