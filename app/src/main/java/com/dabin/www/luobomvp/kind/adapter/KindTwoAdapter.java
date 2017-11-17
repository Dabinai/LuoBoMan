package com.dabin.www.luobomvp.kind.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class KindTwoAdapter extends RecyclerView.Adapter<KindTwoAdapter.MyLeftViewHolder>{
    private Context context;
    private List<TwoBase.DatasBean.ClassListBean> list;

    public KindTwoAdapter(Context context, List<TwoBase.DatasBean.ClassListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public KindTwoAdapter.MyLeftViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kindtwo_item, parent, false);
        final MyLeftViewHolder leftViewHolder = new MyLeftViewHolder(view);
        /*view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recycleViewItemClickListener.recycleViewItemClickListener(leftViewHolder.getPosition(),view,leftViewHolder);
            }
        });*/

        return leftViewHolder;
    }

    @Override
    public void onBindViewHolder(KindTwoAdapter.MyLeftViewHolder holder, final int position) {
        //设置种类标题
        //final MyLeftViewHolder myHolder = new MyLeftViewHolder(holder.itemView);
        //设置标题
        holder.twoTv.setText(list.get(position).getGc_name());

        holder.modelOne.getUrlThree(list.get(position).getGc_id());
        holder.modelOne.setOnThreeFinish(holder);
        //三级请求
      /*  final ModelOne modelOne = new ModelOne();*/
      /*  modelOne.getUrlThree(list.get(position).getGc_id());
        modelOne.setOnThreeFinish(new ModelOne.OnThreeFinish() {
            @Override
            public void ThreeFinish(List<ThreeBase.DatasBean.ClassListBean> class_listthree) {
                myHolder.twoGridView.setAdapter(new KindThreeAdapter(context,class_listthree));
            }
        });*/


    }

    @Override
    public int getItemCount() {
        return list.size();
    }




    public class MyLeftViewHolder extends RecyclerView.ViewHolder implements ModelOne.OnThreeFinish{
        private ModelOne modelOne;
        private TextView twoTv;
        private GridView twoGridView;
        public MyLeftViewHolder(View itemView) {
            super(itemView);
            twoTv = (TextView) itemView.findViewById(R.id.two_tv);
            twoGridView = (GridView) itemView.findViewById(R.id.two_gridview);
            modelOne = new ModelOne();
        }

        @Override
        public void ThreeFinish(List<ThreeBase.DatasBean.ClassListBean> class_listthree) {
            Log.d("mylog", "ThreeFinish: 嘿嘿");
            twoGridView.setAdapter(new KindThreeAdapter(context,class_listthree));
        }
    }

    //声明成员变量
    public OnRecycleViewItemClickListener recycleViewItemClickListener;

    //定义点击接口
    public interface OnRecycleViewItemClickListener{
        void recycleViewItemClickListener(int position, View view, RecyclerView.ViewHolder viewHolder);
    }

    //提供set方法
    public void setRecycleViewItemClickListener(OnRecycleViewItemClickListener recycleViewItemClickListener) {
        this.recycleViewItemClickListener = recycleViewItemClickListener;
    }
}
