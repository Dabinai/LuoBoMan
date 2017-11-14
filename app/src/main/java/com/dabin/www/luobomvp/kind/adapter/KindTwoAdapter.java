package com.dabin.www.luobomvp.kind.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.kind.bean.ThreeBase;
import com.dabin.www.luobomvp.kind.bean.TwoBase;
import com.dabin.www.luobomvp.kind.model.ModelOne;

import java.util.List;

/**
 * Created by Dabin on 2017/11/13.
 */

public class KindTwoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<TwoBase.DatasBean.ClassListBean> list;

    public KindTwoAdapter(Context context, List<TwoBase.DatasBean.ClassListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kindtwo_item, parent, false);
        final MyLeftViewHolder leftViewHolder = new MyLeftViewHolder(view);
        return leftViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //设置种类标题
        final MyLeftViewHolder myHolder = new MyLeftViewHolder(holder.itemView);
        //设置标题
        myHolder.twoTv.setText(list.get(position).getGc_name());

        //三级请求
        final ModelOne modelOne = new ModelOne();
        modelOne.getUrlThree(list.get(position).getGc_id());
        modelOne.setOnThreeFinish(new ModelOne.OnThreeFinish() {
            @Override
            public void ThreeFinish(List<ThreeBase.DatasBean.ClassListBean> class_listthree) {
                myHolder.twoGridView.setAdapter(new KindThreeAdapter(context,class_listthree));
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }




    public class MyLeftViewHolder extends RecyclerView.ViewHolder{
        private TextView twoTv;
        private GridView twoGridView;
        public MyLeftViewHolder(View itemView) {
            super(itemView);
            twoTv = (TextView) itemView.findViewById(R.id.two_tv);
            twoGridView = (GridView) itemView.findViewById(R.id.two_gridview);
        }
    }

 /*   //声明成员变量
    public OnRecycleViewItemClickListener recycleViewItemClickListener;

    //定义点击接口
    public interface OnRecycleViewItemClickListener{
        void recycleViewItemClickListener(int position, View view, RecyclerView.ViewHolder viewHolder);
    }

    //提供set方法
    public void setRecycleViewItemClickListener(OnRecycleViewItemClickListener recycleViewItemClickListener) {
        this.recycleViewItemClickListener = recycleViewItemClickListener;
    }*/
}
