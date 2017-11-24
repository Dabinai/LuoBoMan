package com.dabin.www.luobomvp.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.home.bean.HomeBase;
import com.dabin.www.luobomvp.utils.ToastShow;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Dabin on 2017/11/10.
 */

public class RemenAdapter extends RecyclerView.Adapter<RemenAdapter.MyViewHolder> {

    private Context context;
    private List<HomeBase.DataBean.ActivityInfoBean.ActivityInfoListBean> activityInfoList;

    public RemenAdapter(Context context, List<HomeBase.DataBean.ActivityInfoBean.ActivityInfoListBean> activityInfoList) {
        this.context = context;
        this.activityInfoList = activityInfoList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.remen_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ImageLoader.getInstance().displayImage(activityInfoList.get(position).getActivityImg(), holder.remenImage);
        holder.remenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* context.startActivity(new Intent(context, BannerWeb.class));*/
                ToastShow.showLong(context,"热门图");
            }
        });
    }

    @Override
    public int getItemCount() {
        return activityInfoList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView remenImage;

        public MyViewHolder(View view) {
            super(view);
            remenImage = view.findViewById(R.id.remen_iamge);
        }
    }
}
