package com.example.myapplication66;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Subwork3 extends AppCompatActivity {
    RecyclerView recyclerView;

    ArrayList<Item3> items3= new ArrayList<>();

    ItemAdapter3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subwork3);



        recyclerView=findViewById(R.id.recycler);
        adapter= new ItemAdapter3(this, items3);
        recyclerView.setAdapter(adapter);

        //리사이클러뷰의 레이아웃 매니저 설정
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);


        String serverUrl ="http://contest.dothome.co.kr/android/edujson.php";

        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.POST, serverUrl, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response){

                items3.clear();
                adapter.notifyDataSetChanged();
                try{
                    for(int i = 0;i <response.length();i++){
                        JSONObject jsonObject= response.getJSONObject(i);

                        int edu_id = Integer.parseInt(jsonObject.getString("edu_id"));
                        String name = jsonObject.getString("name");
                        String image = jsonObject.getString("image");
                        String goal = jsonObject.getString("goal");
                        String msg = jsonObject.getString("msg");
                        String url = jsonObject.getString("url");


                        items3.add(0,new Item3(edu_id,name,image,goal,msg,url));
                        adapter.notifyItemInserted(0);
                    }
                }catch (JSONException e){e.printStackTrace();}
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Toast.makeText(Subwork3.this,"ERROR",Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);



    }
}

