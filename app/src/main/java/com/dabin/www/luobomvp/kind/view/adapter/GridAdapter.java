package com.dabin.www.luobomvp.kind.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.commodi.bean.ShowBean;
import com.dabin.www.luobomvp.commodi.view.CommodiActivity;
import com.dabin.www.luobomvp.kind.view.bean.RightBase;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;


/**
 * Created by Dabin on 2017/11/17.
 */

public class GridAdapter extends BaseAdapter{

    private ArrayList<RightBase.DataBean.ListBean> list;
    private Context context;

    public GridAdapter(ArrayList<RightBase.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.kind_grid_item,null);
        }
        TextView gridName = view.findViewById(R.id.grid_name);
        gridName.setText(list.get(i).getName());
        gridName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().postSticky(new ShowBean(2));
                context.startActivity(new Intent(context,CommodiActivity.class));
            }
        });



        return view;
    }
}
