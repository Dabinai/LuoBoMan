package com.dabin.www.luobomvp.kind.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.kind.bean.ThreeBase;

import java.util.List;

/**
 * Created by Dabin on 2017/11/13.
 */

public class KindThreeAdapter extends BaseAdapter {
    private Context context;
    private List<ThreeBase.DatasBean.ClassListBean> list;

    public KindThreeAdapter(Context context, List<ThreeBase.DatasBean.ClassListBean> list){
        this.context = context;
        this.list = list;
    }



    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = View.inflate(context, R.layout.kindthree_item,null);
            holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.tv_gv_type);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(list.get(position).getGc_name());
        return convertView;
    }
    class ViewHolder{
        TextView tv;
    }
}