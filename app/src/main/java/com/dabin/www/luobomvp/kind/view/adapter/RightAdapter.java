package com.dabin.www.luobomvp.kind.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.kind.view.bean.RightBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dabin on 2017/11/17.
 */

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.MyRightHolder>{

    private List<RightBase.DataBean> dataright;
    private Context context;

    public RightAdapter(List<RightBase.DataBean> dataright, Context context) {
        this.dataright = dataright;
        this.context = context;
    }

    @Override
    public MyRightHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyRightHolder myRightHolder = new MyRightHolder(LayoutInflater.from(context).inflate(R.layout.kind_right_item, parent, false));
        return myRightHolder;
    }

    @Override
    public void onBindViewHolder(MyRightHolder holder, int position) {
        holder.rightTitle.setText(dataright.get(position).getName());

        ArrayList<RightBase.DataBean.ListBean> list = new ArrayList<>();
        list.clear();
        for(int j = 0; j < dataright.get(position).getList().size(); j++){
            RightBase.DataBean.ListBean listBean = dataright.get(position).getList().get(j);
            list.add(listBean);
        }
        holder.rigthGrid.setAdapter(new GridAdapter(list,context));
    }

    @Override
    public int getItemCount() {
        return dataright.size();
    }

    class MyRightHolder extends RecyclerView.ViewHolder{
        TextView rightTitle;
        GridView rigthGrid;
        public MyRightHolder(View itemView) {
            super(itemView);
            rightTitle = itemView.findViewById(R.id.right_title);
            rigthGrid = itemView.findViewById(R.id.right_gridview);
        }
    }
}
