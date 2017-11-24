package com.dabin.www.luobomvp.dinglist;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.dinglist.adapter.DingListAdapter;
import com.dabin.www.luobomvp.dinglist.bean.DingListBase;
import com.dabin.www.luobomvp.dinglist.presenter.Presenter;
import com.dabin.www.luobomvp.dinglist.view.IView;
import com.dabin.www.luobomvp.utils.SharedPreferencesUtils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DingListActivity extends AppCompatActivity implements IView{

    @BindView(R.id.dinglist_xrecycler)
    XRecyclerView dinglistXrecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ding_list);
        ButterKnife.bind(this);
        int uid = (int) SharedPreferencesUtils.get(this, "UID", -1);
        new Presenter(this).setUrl(uid + "");
    }

    @Override
    public void getData(DingListBase dingListBase) {
        dinglistXrecycler.setLayoutManager(new LinearLayoutManager(DingListActivity.this));
        dinglistXrecycler.setItemAnimator(new DefaultItemAnimator());
        DingListAdapter dingListAdapter = new DingListAdapter(DingListActivity.this, dingListBase);
        dinglistXrecycler.setAdapter(dingListAdapter);

        dingListAdapter.setOnItemClickon(new DingListAdapter.OnItemClickon() {
            @Override
            public void ItemClickon(View v, int position) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(DingListActivity.this);
                dialog.setTitle("订单")
                        .setMessage("是否修改订单状态？")
                        .setPositiveButton("修改", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                AlertDialog.Builder dialogtwo = new AlertDialog.Builder(DingListActivity.this);
                                dialogtwo.setTitle("订单状态");
                                final String[] items={"待支付","已支付","已取消"};
                                dialogtwo.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });
                                dialogtwo.setCancelable(true);   //对话框可取消
                                AlertDialog alertDialog = dialogtwo.create();
                                alertDialog.show();
                            }
                        })
                        .setNegativeButton("我在想想", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();
            }
        });
    }
}
