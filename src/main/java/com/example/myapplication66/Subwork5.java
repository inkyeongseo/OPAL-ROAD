package com.example.myapplication66;



import android.app.Activity;

import android.app.ProgressDialog;

import android.content.Intent;
import android.os.AsyncTask;

import android.os.Bundle;

import android.view.View;

import android.widget.EditText;

import android.widget.Toast;


import com.example.myapplication66.MainActivity;
import com.example.myapplication66.R;
import com.example.myapplication66.Subwork4;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.io.OutputStreamWriter;

import java.net.URL;

import java.net.URLConnection;

import java.net.URLEncoder;







public class Subwork5 extends Activity {


    private EditText editTextName;
    private EditText editTextTel;
    private EditText editTextAdd;
    private EditText editTextMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subwork5);

        editTextName = (EditText) findViewById(R.id.name);
        editTextTel = (EditText)findViewById(R.id.tel);
        editTextAdd = (EditText) findViewById(R.id.address);
        editTextMsg = (EditText)findViewById(R.id.msg);
    }



    public void insert(View view){
        String name = editTextName.getText().toString();
        String tel = editTextTel.getText().toString();
        String address = editTextAdd.getText().toString();
        String msg = editTextMsg.getText().toString();

        insertToDatabase(name, tel, address, msg);
        Intent intent = new Intent(getApplicationContext(), Subwork4.class);
        startActivity(intent);

    }



    private void insertToDatabase(String name, String tel,String address, String msg){


        class InsertData extends AsyncTask<String, Void, String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Subwork5.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }
            @Override
            protected String doInBackground(String... params) {

                try{
                        String name = (String)params[0];
                        String tel = (String)params[1];
                        String address = (String)params[2];
                        String msg = (String)params[3];

                        String link="http://contest.dothome.co.kr/android/board.php";
                        String data  = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
                        data += "&" + URLEncoder.encode("tel", "UTF-8") + "=" + URLEncoder.encode(tel, "UTF-8")+ "&" + URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(address, "UTF-8")+ "&" + URLEncoder.encode("msg", "UTF-8") + "=" + URLEncoder.encode(msg, "UTF-8");

                        URL url = new URL(link);
                        URLConnection conn = url.openConnection();

                        conn.setDoOutput(true);
                        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                        wr.write( data );
                        wr.flush();

                        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        StringBuilder sb = new StringBuilder();
                        String line = null;

                        // Read Server Response
                        while((line = reader.readLine()) != null)
                        {
                            sb.append(line);
                            break;
                    }
                    return sb.toString();
                }
                catch(Exception e){
                    return new String("Exception: " + e.getMessage());
                }
            }
        }
        InsertData task = new InsertData();
        task.execute(name,tel,address,msg);
    }

}