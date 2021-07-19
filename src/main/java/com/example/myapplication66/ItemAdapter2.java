package com.example.myapplication66;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter2 extends RecyclerView.Adapter {

    Context context;
    ArrayList<Item2> items2;

    public ItemAdapter2(Context context, ArrayList<Item2> items2){
        this.context = context;
        this.items2 = items2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.recycler_item2,parent,false);

        VH holder = new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH) holder;

        Item2 item2= items2.get(position);
        vh.tvName.setText(item2.getName());
        vh.tvTel.setText(item2.getTel());
        vh.tvAddress.setText(item2.getAddress());
        vh.tvMsg.setText(item2.getMsg());
        vh.tvDate.setText(item2.getDate());
    }

    @Override
    public int getItemCount() {
        return items2.size();
    }
    class VH extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvTel;
        TextView tvAddress;
        TextView tvMsg;
        TextView tvDate;

        public VH(@NonNull View itemView) {
            super(itemView);

            tvName=itemView.findViewById(R.id.name);
            tvTel=itemView.findViewById(R.id.tel);
            tvAddress=itemView.findViewById(R.id.address);
            tvMsg=itemView.findViewById(R.id.msg);
            tvDate=itemView.findViewById(R.id.date);

        }
    }
}
