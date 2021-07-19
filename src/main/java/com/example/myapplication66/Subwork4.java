package com.example.myapplication66;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
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

public class Subwork4 extends AppCompatActivity {
    RecyclerView recyclerView;

    ArrayList<Item2> items= new ArrayList<>();

    ItemAdapter2 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subwork4);


        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab_main);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Subwork4.this,Subwork5.class);
                startActivity(intent);
            }
        });

        recyclerView=findViewById(R.id.recycler);
        adapter= new ItemAdapter2(this, items);
        recyclerView.setAdapter(adapter);

        //리사이클러뷰의 레이아웃 매니저 설정
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);


        String serverUrl ="http://contest.dothome.co.kr/android/post.php";

        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.POST, serverUrl, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response){

                items.clear();
                adapter.notifyDataSetChanged();
                try{
                    for(int i = 0;i <response.length();i++){
                        JSONObject jsonObject= response.getJSONObject(i);

                        int board_id = Integer.parseInt(jsonObject.getString("board_id"));
                        String name = jsonObject.getString("name");
                        String tel = jsonObject.getString("tel");
                        String address = jsonObject.getString("address");
                        String msg = jsonObject.getString("msg");
                        String date = jsonObject.getString("date");


                        items.add(0,new Item2(board_id,name,tel,address,msg,date));
                        adapter.notifyItemInserted(0);
                    }
                }catch (JSONException e){e.printStackTrace();}
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Toast.makeText(Subwork4.this,"ERROR",Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);



    }
    @Override
    public void onBackPressed() {
        //Alert로 종료시키기
        Intent intent = new Intent(Subwork4.this,MainActivity.class);
        startActivity(intent);

    }

}

