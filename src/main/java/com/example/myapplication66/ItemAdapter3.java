package com.example.myapplication66;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ItemAdapter3 extends RecyclerView.Adapter {

    Context context;
    ArrayList<Item3> items3;

    public ItemAdapter3(Context context, ArrayList<Item3> items3){
        this.context = context;
        this.items3 = items3;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.recycler_item3,parent,false);

        VH holder = new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH) holder;

        final Item3 item3= items3.get(position);
        vh.tvName.setText(item3.getName());
        vh.tvGoal.setText(item3.getGoal());
        vh.tvMsg.setText(item3.getMsg());

        Glide.with(context).load(item3.getImage()).into(vh.iv);

        vh.seeMoreButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v){
                Uri webpage = Uri.parse(item3.getUrl());
                Intent intents = new Intent(Intent.ACTION_VIEW, webpage);
                v.getContext().startActivity(intents);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items3.size();
    }
    class VH extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvGoal;
        TextView tvMsg;
        ImageView iv;
        public Button seeMoreButton;

        public VH(View itemView) {
            super(itemView);

            tvName=itemView.findViewById(R.id.name);
            tvGoal=itemView.findViewById(R.id.goal);
            tvMsg=itemView.findViewById(R.id.msg);
            iv=itemView.findViewById(R.id.iv);
            seeMoreButton = (Button)itemView.findViewById(R.id.seemore);
        }
    }
}
