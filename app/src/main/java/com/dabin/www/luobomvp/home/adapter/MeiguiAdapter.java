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

public class MeiguiAdapter extends RecyclerView.Adapter<MeiguiAdapter.MyViewHolder>{
    private Context context;
    private List<HomeBase.DataBean.SubjectsBean.GoodsListBeanX> goodsList;

    public MeiguiAdapter(Context context, List<HomeBase.DataBean.SubjectsBean.GoodsListBeanX> goodsList) {
        this.context = context;
        this.goodsList = goodsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.meigui_item, parent, false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ImageLoader.getInstance().displayImage(goodsList.get(position).getGoodsImage(),holder.meiguiImage);
        holder.meiguiImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* context.startActivity(new Intent(context, BannerWeb.class));*/
                ToastShow.showLong(context,"玫瑰图");
            }
        });
    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView meiguiImage;

        public MyViewHolder(View view) {
            super(view);
            meiguiImage = (ImageView) view.findViewById(R.id.meigui_image);
        }
    }
}
