package com.dabin.www.luobomvp.mine.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.utils.SharedPreferencesUtils;
import com.dabin.www.luobomvp.utils.ToastShow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Dabin on 2017/11/9.
 */

public class MineFragment extends Fragment {


    @BindView(R.id.mine_headimage)
    ImageView mineHeadimage;
    Unbinder unbinder;
    @BindView(R.id.mine_headname)
    TextView mineHeadname;
    boolean isLogin;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onResume() {
        super.onResume();
        isLogin = (boolean) SharedPreferencesUtils.get(getActivity(), "IsLogin", false);
        if(isLogin){
            mineHeadname.setText("登录");
        }else{
            mineHeadname.setText("未登录");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    // 头像点击
    @OnClick(R.id.mine_headimage)
    public void onViewClicked() {
        if (isLogin) {
            
            startActivity(new Intent(getActivity(), MessageActivity.class));
            ToastShow.showLong(getActivity(), "信息界面");
        } else {
            startActivity(new Intent(getActivity(), LoginActivity.class));
            ToastShow.showLong(getActivity(), "登录界面");
        }

    }
}
