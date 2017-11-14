package com.dabin.www.luobomvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.dabin.www.luobomvp.base.BaseActivity;
import com.dabin.www.luobomvp.home.view.HomeFragment;
import com.dabin.www.luobomvp.kind.view.KindFragment;
import com.dabin.www.luobomvp.mine.view.LoginActivity;
import com.dabin.www.luobomvp.mine.view.MineFragment;
import com.dabin.www.luobomvp.shop.view.ShopFragment;
import com.dabin.www.luobomvp.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {


    @BindView(R.id.fragment)
    FrameLayout fragment;
    @BindView(R.id.home_btn)
    RadioButton homeBtn;
    @BindView(R.id.kind_btn)
    RadioButton kindBtn;
    @BindView(R.id.shop_btn)
    RadioButton shopBtn;
    @BindView(R.id.mine_btn)
    RadioButton mineBtn;
    private boolean isLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //默认显示首页
        HomeFragment homeFragment = new HomeFragment();
        FragmentManager sp = getSupportFragmentManager();
        FragmentTransaction ft = sp.beginTransaction();
        ft.replace(R.id.fragment,homeFragment);
        ft.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        isLogin = (boolean) SharedPreferencesUtils.get(MainActivity.this,"IsLogin",false);
    }

    @OnClick({R.id.home_btn, R.id.kind_btn, R.id.shop_btn, R.id.mine_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_btn:   //首页
                HomeFragment homeFragment = new HomeFragment();
                FragmentManager sp = getSupportFragmentManager();
                FragmentTransaction ft = sp.beginTransaction();
                ft.replace(R.id.fragment,homeFragment);
                ft.commit();
                break;
            case R.id.kind_btn:  //分类
                    if(isLogin){
                        KindFragment kindFragment = new KindFragment();
                        FragmentManager sp1 = getSupportFragmentManager();
                        FragmentTransaction ft1 = sp1.beginTransaction();
                        ft1.replace(R.id.fragment,kindFragment);
                        ft1.commit();
                    }else{
                        startActivity(new Intent(MainActivity.this,LoginActivity.class));
                    }



                break;
            case R.id.shop_btn: //购物车
                if(isLogin){
                    ShopFragment shopFragment = new ShopFragment();
                    FragmentManager sp2 = getSupportFragmentManager();
                    FragmentTransaction ft2 = sp2.beginTransaction();
                    ft2.replace(R.id.fragment,shopFragment);
                    ft2.commit();
                }else{
                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                }
                break;
            case R.id.mine_btn: //个人
                if(isLogin){
                    MineFragment mineFragment = new MineFragment();
                    FragmentManager sp3 = getSupportFragmentManager();
                    FragmentTransaction ft3 = sp3.beginTransaction();
                    ft3.replace(R.id.fragment,mineFragment);
                    ft3.commit();
                }else{
                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferencesUtils.clear(MainActivity.this);
    }
}
