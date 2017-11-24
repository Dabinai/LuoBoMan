package com.dabin.www.luobomvp.shop.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.shop.adapter.ExpandAdapter;
import com.dabin.www.luobomvp.shop.bean.DingBase;
import com.dabin.www.luobomvp.shop.bean.Shopbase;
import com.dabin.www.luobomvp.shop.bean.UpdateBase;
import com.dabin.www.luobomvp.shop.presenter.Presenter;
import com.dabin.www.luobomvp.utils.SharedPreferencesUtils;
import com.dabin.www.luobomvp.utils.ToastShow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Dabin on 2017/11/9.
 */

public class ShopFragment extends Fragment implements IView {


    @BindView(R.id.shopExpand)
    ExpandableListView shopExpand;
    Unbinder unbinder;
    @BindView(R.id.checkall)
    CheckBox checkall;
    @BindView(R.id.numall)
    TextView numall;
    @BindView(R.id.moneyall)
    TextView moneyall;
    @BindView(R.id.jiesuai)
    Button jiesuai;
    private int uid;
    private Presenter presenter;
    private int numALL = 0;
    private float moneyALL = 0;

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
        // 通过SP获得uid
        uid = (int) SharedPreferencesUtils.get(getActivity(), "UID", 0);
        //实例化P层
        presenter = new Presenter(this);
        presenter.setUrl(uid + "");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    // IView层的接口
    @Override
    public void getData(final Shopbase shopbase) {
        final ExpandAdapter adapter = new ExpandAdapter(getActivity(), shopbase);
        shopExpand.setAdapter(adapter);
        for (int h = 0; h < adapter.getGroupCount(); h++) {
            shopExpand.expandGroup(h);
        }
        //全选按钮
        checkall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numALL = 0;
                moneyALL = 0;
                boolean ischeck = checkall.isChecked();
                for (int i = 0; i < shopbase.getData().size(); i++) {
                    shopbase.getData().get(i).setSelected(ischeck);
                    for (int j = 0; j < shopbase.getData().get(i).getList().size(); j++) {
                        if (ischeck) {
                            shopbase.getData().get(i).getList().get(j).setSelected("1");
                            int num = shopbase.getData().get(i).getList().get(j).getNum();
                            float price = shopbase.getData().get(i).getList().get(j).getPrice();
                            numALL += num;
                            moneyALL += num * price;
                            numall.setText(numALL + "");
                            moneyall.setText(moneyALL + "");
                            adapter.notifyDataSetChanged();

                        } else {
                            shopbase.getData().get(i).getList().get(j).setSelected("0");
                            numALL = 0;
                            moneyALL = 0;
                            numall.setText(numALL + "");
                            moneyall.setText(moneyALL + "");
                        }
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });


        adapter.setmOnAllClickListener(new ExpandAdapter.onAllClickListener() {
            //减少
            @Override
            public void onDownClick(int groupId, int childId) {
                int num = shopbase.getData().get(groupId).getList().get(childId).getNum();
                shopbase.getData().get(groupId).getList().get(childId).setNum(--num);
                String selected = shopbase.getData().get(groupId).getList().get(childId).getSelected();
                float price = shopbase.getData().get(groupId).getList().get(childId).getPrice(); //价钱

                if ("1".equals(selected)) {
                    numALL -= 1;
                    moneyALL -= price;
                    numall.setText(numALL + "");
                    moneyall.setText(moneyALL + "");
                }
                adapter.notifyDataSetChanged();
            }

            //添加
            @Override
            public void onUpClick(int groupId, int childId) {
                int num = shopbase.getData().get(groupId).getList().get(childId).getNum();
                shopbase.getData().get(groupId).getList().get(childId).setNum(++num);
                String selected = shopbase.getData().get(groupId).getList().get(childId).getSelected();
                float price = shopbase.getData().get(groupId).getList().get(childId).getPrice(); //价钱
                if ("1".equals(selected)) {
                    numALL += 1;
                    moneyALL += price;
                    numall.setText(numALL + "");
                    moneyall.setText(moneyALL + "");
                }
                adapter.notifyDataSetChanged();
            }

            //完成
            @Override
            public void onComplete(int groupId, int childId) {
                String selected = shopbase.getData().get(groupId).getList().get(childId).getSelected();
                TiJiao(shopbase, groupId, childId, selected); //提交
            }

            //子类选中
            @Override
            public void onChangeClick(int groupId, int childId) {
                String selected = shopbase.getData().get(groupId).getList().get(childId).getSelected();
                if ("1".equals(selected)) {
                    adapter.notifyDataSetChanged();
                    shopbase.getData().get(groupId).getList().get(childId).setSelected("0");
                    selected = "0";
                    //int num = TiJiao(shopbase, groupId, childId, selected); //提交
                    int num = shopbase.getData().get(groupId).getList().get(childId).getNum();
                    float price = shopbase.getData().get(groupId).getList().get(childId).getPrice(); //价钱
                    adapter.notifyDataSetChanged();

                    moneyALL -= num * price;
                    numALL -= num;
                    numall.setText(numALL + "");
                    moneyall.setText(moneyALL + "");
                    //全选
                    quanxuan(groupId, childId, shopbase);


                } else {
                    adapter.notifyDataSetChanged();
                    shopbase.getData().get(groupId).getList().get(childId).setSelected("1");
                    selected = "1";
                    //int num = TiJiao(shopbase, groupId, childId, selected);
                    int num = shopbase.getData().get(groupId).getList().get(childId).getNum();
                    float price = shopbase.getData().get(groupId).getList().get(childId).getPrice();
                    adapter.notifyDataSetChanged();

                    numALL += num;
                    moneyALL += num * price;
                    numall.setText(numALL + "");
                    moneyall.setText(moneyALL + "");
                    //全选
                    quanxuan(groupId, childId, shopbase);
                }

            }

            //父类选中
            @Override
            public void onParentClick(int groupId) {
                boolean selected = shopbase.getData().get(groupId).isSelected();
                boolean flag = true;
                if (!selected) {
                    quanxuan2(groupId, shopbase, flag);  // 设置group多选框和全选框
                    for (int i = 0; i < shopbase.getData().get(groupId).getList().size(); i++) {
                        shopbase.getData().get(groupId).getList().get(i).setSelected("1");
                        int num = shopbase.getData().get(groupId).getList().get(i).getNum();
                        float price = shopbase.getData().get(groupId).getList().get(i).getPrice();
                        numALL += num;
                        moneyALL += num * price;
                        numall.setText(numALL + "");
                        moneyall.setText(moneyALL + "");

                    }
                    shopbase.getData().get(groupId).setSelected(true);
                } else {
                    flag = false;
                    quanxuan2(groupId, shopbase, flag);// 设置group多选框和全选框
                    for (int i = 0; i < shopbase.getData().get(groupId).getList().size(); i++) {
                        shopbase.getData().get(groupId).getList().get(i).setSelected("0");
                        int num = shopbase.getData().get(groupId).getList().get(i).getNum();
                        float price = shopbase.getData().get(groupId).getList().get(i).getPrice();
                        numALL -= num;
                        moneyALL -= num * price;
                        numall.setText(numALL + "");
                        moneyall.setText(moneyALL + "");
                    }
                    shopbase.getData().get(groupId).setSelected(false);
                }
                adapter.notifyDataSetChanged();

            }
        });
    }

    //返回成功
    @Override
    public void getDataUpdate(UpdateBase updateBase) {
        ToastShow.showLong(getActivity(), updateBase.getMsg());
    }

    //生成订单
    @Override
    public void getDataDing(DingBase dingBase) {
        ToastShow.showLong(getActivity(),dingBase.getMsg());
    }

    //全选的初步判断
    public void quanxuan(int groupId, int childId, Shopbase shopbase) {
        boolean flag = true;
        String selected = shopbase.getData().get(groupId).getList().get(childId).getSelected();
        for (int i = 0; i < shopbase.getData().get(groupId).getList().size(); i++) {
            if ("0".equals(selected)) {
                flag = false;
                break;
            }
        }
        if (flag == true) {
            quanxuan2(groupId, shopbase, flag);
        } else {
            quanxuan2(groupId, shopbase, flag);
        }
    }

    // 设置group的多选框、全选的多选框
    public void quanxuan2(int groupId, Shopbase shopbase, boolean flag) {
        shopbase.getData().get(groupId).setSelected(flag);
        for (int h = 0; h < shopbase.getData().size(); h++) {
            boolean selected1 = shopbase.getData().get(h).isSelected();
            if (selected1 == false) {
                flag = false;
                break;
            }
        }
        if (flag) {
            checkall.setChecked(true);
        } else {
            checkall.setChecked(false);
        }
    }

    //提交服务器
    public int TiJiao(Shopbase shopbase, int groupId, int childId, String selected) {
        String sellerid = shopbase.getData().get(groupId).getSellerid();
        String pid = shopbase.getData().get(groupId).getList().get(childId).getPid();
        int num = shopbase.getData().get(groupId).getList().get(childId).getNum();
        presenter.setUpdateUrl(uid + "", sellerid, pid, num + "", selected);
        return num;
    }

    //结算
    @OnClick(R.id.jiesuai)
    public void onViewClicked() {
        new Presenter(this).setDingdan(uid+"",moneyALL+"");
    }
}
