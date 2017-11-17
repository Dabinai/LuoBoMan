package com.dabin.www.luobomvp.kind.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.kind.adapter.KindOneAdapter;
import com.dabin.www.luobomvp.kind.adapter.KindTwoAdapter;
import com.dabin.www.luobomvp.kind.bean.OneBase;
import com.dabin.www.luobomvp.kind.bean.TwoBase;
import com.dabin.www.luobomvp.kind.presenter.PresenterOne;
import com.dabin.www.luobomvp.utils.API;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Dabin on 2017/11/9.
 */

public class KindFragment extends Fragment implements IViewOne {


    @BindView(R.id.kindRecycler_left)
    RecyclerView kindRecyclerLeft;
    @BindView(R.id.kindRecycler_right)
    RecyclerView kindRecyclerRight;
    Unbinder unbinder;
    PresenterOne presenterOne;

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
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);
        //得到WindowManager
        WindowManager windowManager = getActivity().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        //得到屏幕宽
        int width = display.getWidth();
        //将RecyclerView宽设置为屏幕宽的1/5
        params.width = width * 1 / 5;
        kindRecyclerLeft.setLayoutParams(params);
        //得到RecyclerView布局管理器
        LinearLayoutManager leftLayoutManager = new LinearLayoutManager(getActivity());
        //RecyclerView设置布局管理器
        kindRecyclerLeft.setLayoutManager(leftLayoutManager);
        //得到RecyclerView布局管理器
        LinearLayoutManager rightLayoutManager = new LinearLayoutManager(getActivity());
        //RecyclerView设置布局管理器
        kindRecyclerRight.setLayoutManager(rightLayoutManager);
        //获取后台数据，添加适配器

        presenterOne = new PresenterOne(this);
        presenterOne.setUrl(API.TYPE_PATH);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getUrl(final List<OneBase.DatasBean.ClassListBean> class_list) {
        Log.d("aaaaaaaaaaaaaaaaaa", "getUrl: " + class_list.toString());
        final KindOneAdapter kindOneAdapter = new KindOneAdapter(getActivity(), class_list);
        kindRecyclerLeft.setAdapter(kindOneAdapter);
        //二次请求
        kindOneAdapter.setRecycleViewItemClickListener(new KindOneAdapter.OnRecycleViewItemClickListener() {
            @Override
            public void recycleViewItemClickListener(int position, View view, RecyclerView.ViewHolder viewHolder) {
                kindOneAdapter.setTagPosition(position);
                kindOneAdapter.notifyDataSetChanged();
                presenterOne.setUrlTwo(class_list.get(position).getGc_id());

            }
        });
    }

    @Override
    public void getUrlTwo(List<TwoBase.DatasBean.ClassListBean> class_listtwo) {
        KindTwoAdapter kindTwoAdapter = new KindTwoAdapter(getActivity(), class_listtwo);
        kindRecyclerRight.setAdapter(kindTwoAdapter);

    }




}
