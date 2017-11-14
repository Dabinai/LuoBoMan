package com.dabin.www.luobomvp.kind.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.kind.bean.OneBase;

import java.util.List;

/**
 * Created by Dabin on 2017/11/13.
 */

public class KindOneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<OneBase.DatasBean.ClassListBean> list;
    public static int tagPosition;

    public static int getTagPosition() {
        return tagPosition;
    }

    public static void setTagPosition(int tagPosition) {
        KindOneAdapter.tagPosition = tagPosition;
    }

    public KindOneAdapter(Context context, List<OneBase.DatasBean.ClassListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kindone_item, parent, false);
        final MyLeftViewHolder leftViewHolder = new MyLeftViewHolder(view);
        //点击监听
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recycleViewItemClickListener.recycleViewItemClickListener(leftViewHolder.getPosition(), view, leftViewHolder);
            }
        });
        return leftViewHolder;
    }

    //view绑定数据
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //给文本框赋值
        ((MyLeftViewHolder) holder).oneTv.setText(list.get(position).getGc_name());
        if (position == getTagPosition()) {
            holder.itemView.setBackgroundResource(R.color.colorPblBackground);
        } else {
            holder.itemView.setBackgroundResource(R.color.colorWhite3);
        }
        //设置种类图片
        if (list.get(position).getImage().length() > 0) {
            //  Picasso.with(context).load(MyUtils.Unicode2GBK(list.get(position).getImage())).into(((MyLeftViewHolder) holder).iv_type_pic);
            Glide.with(context).load(list.get(position).getImage()).into(((MyLeftViewHolder) holder).oneImage);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyLeftViewHolder extends RecyclerView.ViewHolder {
        private TextView oneTv;
        private ImageView oneImage;

        public MyLeftViewHolder(View itemView) {
            super(itemView);
            oneTv = itemView.findViewById(R.id.one_tv);
            oneImage = itemView.findViewById(R.id.one_image);
        }
    }

    //声明成员变量
    public OnRecycleViewItemClickListener recycleViewItemClickListener;

    //定义点击接口
    public interface OnRecycleViewItemClickListener {
        void recycleViewItemClickListener(int position, View view, RecyclerView.ViewHolder viewHolder);
    }

    //提供set方法
    public void setRecycleViewItemClickListener(OnRecycleViewItemClickListener recycleViewItemClickListener) {
        this.recycleViewItemClickListener = recycleViewItemClickListener;
    }
}
