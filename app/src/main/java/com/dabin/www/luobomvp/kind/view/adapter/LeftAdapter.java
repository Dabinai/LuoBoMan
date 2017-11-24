package com.dabin.www.luobomvp.kind.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.kind.view.bean.LeftBase;

import java.util.List;

/**
 * Created by Dabin on 2017/11/17.
 */

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.MyLeftHolder>{

    private List<LeftBase.DataBean> data;
    private Context context;

    public LeftAdapter(List<LeftBase.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public static int tagPosition;

    public static int getTagPosition() {
        return tagPosition;
    }

    public static void setTagPosition(int tagPosition) {
        LeftAdapter.tagPosition = tagPosition;
    }

    private onItemClik onItemClik;
    public interface onItemClik{
        void itemClick(View view, int position);
    }
    public void setOnItemClik(onItemClik onItemClik){
        this.onItemClik =onItemClik;
    }

    @Override
    public MyLeftHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyLeftHolder myLeftHolder = new MyLeftHolder(LayoutInflater.from(context).inflate(R.layout.kind_left_item, parent, false));
        return myLeftHolder;
    }

    @Override
    public void onBindViewHolder(MyLeftHolder holder, final int position) {
        holder.leftName.setText(data.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClik.itemClick(view,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyLeftHolder extends RecyclerView.ViewHolder{

        TextView leftName;
        public MyLeftHolder(View itemView) {
            super(itemView);
            leftName = itemView.findViewById(R.id.left_name);
        }
    }
}
