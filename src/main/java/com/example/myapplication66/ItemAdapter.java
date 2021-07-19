package com.example.myapplication66;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Item> items;

    public ItemAdapter(Context context, ArrayList<Item> items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.recycler_item,parent,false);

        VH holder = new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH) holder;

        Item item= items.get(position);
        vh.tvName.setText(item.getName());
        vh.tvTel.setText(item.getTel());
        vh.tvSort.setText(item.getSort());
        vh.tvNum.setText(item.getNum());
        vh.tvIns.setText(item.getIns());
        vh.tvMsg.setText(item.getMsg());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    class VH extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvTel;
        TextView tvSort;
        TextView tvIns;
        TextView tvNum;
        TextView tvMsg;

        public VH(@NonNull View itemView) {
            super(itemView);

            tvName=itemView.findViewById(R.id.tv_name);
            tvTel=itemView.findViewById(R.id.tv_tel);
            tvNum=itemView.findViewById(R.id.tv_num);
            tvIns=itemView.findViewById(R.id.tv_ins);
            tvSort=itemView.findViewById(R.id.tv_sort);
            tvMsg=itemView.findViewById(R.id.tv_msg);

        }
    }
}
