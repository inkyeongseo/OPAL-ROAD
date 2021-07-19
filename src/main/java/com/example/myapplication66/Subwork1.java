package com.example.myapplication66;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Subwork1 extends AppCompatActivity {
    RecyclerView recyclerView;

    ArrayList<Item> items= new ArrayList<>();

    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subwork);

        recyclerView=findViewById(R.id.recycler);
        adapter= new ItemAdapter(this, items);
        recyclerView.setAdapter(adapter);

        //리사이클러뷰의 레이아웃 매니저 설정
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);


        String serverUrl ="http://contest.dothome.co.kr/android/workjson.php";

        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.POST, serverUrl, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response){

                items.clear();
                adapter.notifyDataSetChanged();
                try{
                    for(int i = 0;i <response.length();i++){
                        JSONObject jsonObject= response.getJSONObject(i);

                        int work_id = Integer.parseInt(jsonObject.getString("work_id"));
                        String ins = jsonObject.getString("ins");
                        String name = jsonObject.getString("name");
                        String sort = jsonObject.getString("sort");
                        String tel = jsonObject.getString("tel");
                        String num = jsonObject.getString("num");
                        String msg = jsonObject.getString("msg");

                        items.add(0,new Item(work_id,ins,name,sort,tel,num,msg));
                        adapter.notifyItemInserted(0);
                    }
                }catch (JSONException e){e.printStackTrace();}
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Toast.makeText(Subwork1.this,"ERROR",Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);


    }
}

