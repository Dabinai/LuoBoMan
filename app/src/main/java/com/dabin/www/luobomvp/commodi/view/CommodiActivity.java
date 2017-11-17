package com.dabin.www.luobomvp.commodi.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.commodi.adapter.ParticAdapter;
import com.dabin.www.luobomvp.commodi.bean.ComShowBase;
import com.dabin.www.luobomvp.commodi.bean.ParticularsBase;
import com.dabin.www.luobomvp.commodi.bean.ShowBean;
import com.dabin.www.luobomvp.commodi.presenter.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CommodiActivity extends AppCompatActivity implements IView {


    @BindView(R.id.commod_recycler)
    RecyclerView commodRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commodi);
        ButterKnife.bind(this);

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void Onshow(ShowBean showBean) {
        new Presenter(this).setParticUrl(showBean.getPosition() + "");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void getPrrtiData(final List<ParticularsBase.DataBean> data) {
        commodRecycler.setLayoutManager(new LinearLayoutManager(this));
        ParticAdapter particAdapter = new ParticAdapter(CommodiActivity.this, data);
        commodRecycler.setAdapter(particAdapter);
        particAdapter.setOnItemClickListener(new ParticAdapter.OnItemClickListener() {
            @Override
            public void ItemClickListener(int position, View view) {
                EventBus.getDefault().postSticky(new ComShowBase(data));
                startActivity(new Intent(CommodiActivity.this,ComShowActivity.class));
            }
        });


    }


}
