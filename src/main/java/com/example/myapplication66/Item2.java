package com.example.myapplication66;

public class Item2 {
    int board_id;
    String name;
    String tel;
    String address;
    String msg;
    String date;

    public Item2(){
    }

    public Item2(int board_id, String name, String tel, String address, String msg, String date){
        this.board_id = board_id;
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.msg = msg;
        this.date = date;
    }

    public int getBork_id(){
        return board_id;
    }
    public void setBoard_id(int board_id){
        this.board_id = board_id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getTel(){
        return tel;
    }
    public void setTel(String tel){
        this.tel = tel;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public String getMsg(){
        return msg;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }

    public String getDate(){return date;}
    public void setDate(String date){this.date = date;}
}
