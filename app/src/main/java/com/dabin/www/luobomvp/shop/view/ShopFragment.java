package com.dabin.www.luobomvp.shop.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.shop.bean.OneClass;
import com.dabin.www.luobomvp.shop.bean.TwoClass;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Dabin on 2017/11/9.
 */

public class ShopFragment extends Fragment {

    @BindView(R.id.shopExpand)
    ExpandableListView shopExpand;
    Unbinder unbinder;
    private ArrayList<OneClass> data;//总数据
    private OneClass oneClass;
    private  ArrayList<TwoClass> twodata;//子数据

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<OneClass> data = new ArrayList<>(); //总数据
        ArrayList<TwoClass> twodata = new ArrayList<>();//子数据

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= i; j++) {
                twodata.add(new TwoClass(j + "商铺的" + j + "商品", "50", 1, false));
            }
            oneClass = new OneClass(i + "商铺", false, twodata);
            data.add(oneClass);
        }



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
