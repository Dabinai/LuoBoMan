package com.dabin.www.luobomvp.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.home.bean.HomeBase;
import com.dabin.www.luobomvp.home.bean.WebBase;
import com.dabin.www.luobomvp.home.view.WebViewActivity;
import com.dabin.www.luobomvp.utils.ToastShow;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by Dabin on 2017/11/10.
 */

public class Qiandao extends RecyclerView.Adapter<Qiandao.MyViewHolder> {

    private Context context;
    private List<HomeBase.DataBean.Ad5Bean> ad5;

    public Qiandao(Context context, List<HomeBase.DataBean.Ad5Bean> ad5) {
        this.context = context;
        this.ad5 = ad5;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.qiandao_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.qiandanText.setText(ad5.get(position).getTitle());
        ImageLoader.getInstance().displayImage(ad5.get(position).getImage(), holder.qiandaoImage);
        holder.qiandaoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ad_type_dynamic_data = ad5.get(position).getAd_type_dynamic_data();
                EventBus.getDefault().postSticky(new WebBase(ad_type_dynamic_data));
                context.startActivity(new Intent(context, WebViewActivity.class));
                ToastShow.showLong(context,"签到图");
            }
        });
    }

    @Override
    public int getItemCount() {
        return ad5.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView qiandanText;
        ImageView qiandaoImage;

        public MyViewHolder(View view) {
            super(view);
            qiandanText = (TextView) view.findViewById(R.id.qiandao_text);
            qiandaoImage = (ImageView) view.findViewById(R.id.qiandao_iamge);
        }
    }
}
