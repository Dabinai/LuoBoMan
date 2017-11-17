package com.dabin.www.luobomvp.commodi.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.commodi.bean.ParticularsBase;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Dabin on 2017/11/16.
 */

public class ParticAdapter extends RecyclerView.Adapter{

    private Context context;
    private List<ParticularsBase.DataBean> data;

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        void ItemClickListener(int position,View view);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public ParticAdapter(Context context, List<ParticularsBase.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.partic_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        String string = data.get(position).getImages();
        String[] split = string.split("[|]");
        myViewHolder.iamge.setImageURI(split[0].toString());
        myViewHolder.textView.setText(data.get(position).getTitle());

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.ItemClickListener(position,view);
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView iamge;
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            iamge = itemView.findViewById(R.id.commod_image);
            textView = itemView.findViewById(R.id.commod_text);
        }
    }

}
