package com.dabin.www.luobomvp.home.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.home.adapter.HomeAdapter;
import com.dabin.www.luobomvp.home.bean.HomeBase;
import com.dabin.www.luobomvp.home.presenter.PresenterHome;
import com.dabin.www.luobomvp.utils.API;
import com.dabin.www.luobomvp.utils.ToastShow;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Dabin on 2017/11/9.
 */

public class HomeFragment extends Fragment implements IViewHome {


    @BindView(R.id.home_saomao)
    ImageView homeSaomao;
    @BindView(R.id.home_search)
    EditText homeSearch;
    @BindView(R.id.home_message)
    ImageView homeMessage;
    @BindView(R.id.xrecycler_home)
    XRecyclerView xrecyclerHome;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        xrecyclerHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        new PresenterHome(this).setUrl(API.HOMEURL);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.home_saomao, R.id.home_search, R.id.home_message})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_saomao:
                ToastShow.showLong(getActivity(),"扫码");
                break;
            case R.id.home_search:
                ToastShow.showLong(getActivity(),"搜索");
                break;
            case R.id.home_message:
                ToastShow.showLong(getActivity(),"信息");
                break;
        }
    }

    @Override
    public void getData(HomeBase.DataBean data) {
        xrecyclerHome.setAdapter(new HomeAdapter(getActivity(),data));
    }
}
