package com.dabin.www.luobomvp.kind.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dabin.www.luobomvp.MyApp;
import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.kind.view.adapter.LeftAdapter;
import com.dabin.www.luobomvp.kind.view.adapter.RightAdapter;
import com.dabin.www.luobomvp.kind.view.bean.LeftBase;
import com.dabin.www.luobomvp.kind.view.bean.RightBase;
import com.dabin.www.luobomvp.kind.view.presenter.Presenter;
import com.dabin.www.luobomvp.kind.view.view.IView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Dabin on 2017/11/9.
 */

public class KindFragment extends Fragment implements IView{


    @BindView(R.id.leftrecycler)
    RecyclerView leftrecycler;
    @BindView(R.id.rightrecycler)
    RecyclerView rightrecycler;
    Unbinder unbinder;
    private Presenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kind, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter = new Presenter(this);
        presenter.setleftUrl("product/getCatagory");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void getleftData(final List<LeftBase.DataBean> data) {
        leftrecycler.setLayoutManager(new LinearLayoutManager(MyApp.context));
        final LeftAdapter leftAdapter = new LeftAdapter(data,getActivity());
        leftrecycler.setAdapter(leftAdapter);

        leftAdapter.setOnItemClik(new LeftAdapter.onItemClik() {
            @Override
            public void itemClick(View view, int position) {
                leftAdapter.setTagPosition(position);
                leftAdapter.notifyDataSetChanged();
                presenter.setRightUrl("product/getProductCatagory",data.get(position).getCid()+"");
            }
        });
    }

    @Override
    public void getrightData(List<RightBase.DataBean> dataright) {
        rightrecycler.setLayoutManager(new LinearLayoutManager(MyApp.context));
        rightrecycler.setAdapter(new RightAdapter(dataright,getActivity()));
    }
}
