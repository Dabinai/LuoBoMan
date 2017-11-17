package com.dabin.www.luobomvp.shop.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.shop.bean.OneClass;

import java.util.ArrayList;

/**
 * Created by Dabin on 2017/11/15.
 */

public class ExpandAdapter extends BaseExpandableListAdapter{

    private Context context;
    private ArrayList<OneClass> data;

    public ExpandAdapter(Context context, ArrayList<OneClass> data) {
        this.context = context;
        this.data = data;
    }



    @Override
    public int getGroupCount() {
        return data.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return data.get(i).getTwos().size();
    }

    @Override
    public Object getGroup(int i) {
        return data.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return data.get(i).getTwos().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    //先放着
    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.shopone_item,null);
        TextView onename = view.findViewById(R.id.shop_oneText);
        CheckBox oneCheck = view.findViewById(R.id.shop_oneCheck);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
