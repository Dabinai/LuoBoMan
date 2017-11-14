package com.dabin.www.luobomvp.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.home.bean.HomeBase;
import com.dabin.www.luobomvp.utils.GlideImageLoader;
import com.dabin.www.luobomvp.utils.ToastShow;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import cn.iwgang.countdownview.CountdownView;

/**
 * Created by Dabin on 2017/11/9.
 */

public class HomeAdapter extends XRecyclerView.Adapter {

    private List mlist = new ArrayList();
    private Context context;
    private HomeBase.DataBean data;

    private final int TY_Banner = 0;
    private final int TY_Qiandao = 1;
    private final int TY_Remen = 2;
    private final int TY_Zhuanti = 3;
    private final int TY_Meigui = 4;
    private final int TY_Xihuan = 5;

    public HomeAdapter(Context context, HomeBase.DataBean data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (getItemViewType(viewType) == TY_Banner) {  //轮播图
            List<HomeBase.DataBean.Ad1Bean> ad11 = data.getAd1();
            MyBanner myBanner = new MyBanner(LayoutInflater.from(context).inflate(R.layout.homeitem_banner, parent, false));
            return myBanner;
        } else if (getItemViewType(viewType) ==TY_Qiandao) {  //签到
            MyQiandao myQiandao = new MyQiandao(LayoutInflater.from(context).inflate(R.layout.homeiten_qiandao, parent, false));
            return myQiandao;
        }else if(getItemViewType(viewType) == TY_Remen){//热门活动
            MyRemen myRemen = new MyRemen(LayoutInflater.from(context).inflate(R.layout.homeitem_remen, parent, false));
            return myRemen;
        }else if(getItemViewType(viewType) == TY_Zhuanti ){//热门专题
            Zhuanti zhuanti = new Zhuanti(LayoutInflater.from(context).inflate(R.layout.homeitem_zhuanti, parent, false));
            return zhuanti;
        }else if(getItemViewType(viewType) == TY_Meigui){//玫瑰
            Meigui meigui = new Meigui(LayoutInflater.from(context).inflate(R.layout.homeitem_meigui, parent, false));
            return meigui;
        }else{ //猜你喜欢
            Xihuan xihuan = new Xihuan(LayoutInflater.from(context).inflate(R.layout.homeitem_xihuan, parent, false));
            return xihuan;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == TY_Banner) {//轮播图
            MyBanner myBanner = (MyBanner) holder;
            List<HomeBase.DataBean.Ad1Bean> ad1 = data.getAd1();
            for (int i = 0; i < ad1.size(); i++) {
                String imagebanner = ad1.get(i).getImage();
                mlist.add(imagebanner);
            }
            myBanner.homebannerBanner.setImageLoader(new GlideImageLoader());
            myBanner.homebannerBanner.setImages(mlist);
            myBanner.homebannerBanner.start();   // 轮播图
            myBanner.homebannerBanner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                  /*  context.startActivity(new Intent(context, BannerWeb.class));*/
                    ToastShow.showLong(context,"轮播图");
                }
            });
        } else if (getItemViewType(position) ==TY_Qiandao) {  //签到
            MyQiandao myQiandao = (MyQiandao) holder;
            List<HomeBase.DataBean.Ad5Bean> ad5 = data.getAd5();
            myQiandao.homeqiandaoRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
            myQiandao.homeqiandaoRecyclerview.setAdapter(new Qiandao(context, ad5));

        }else if(getItemViewType(position) == TY_Remen){//热门活动
            MyRemen myRemen = (MyRemen) holder;
            myRemen.homeremenDaojishi.start(900000000);
            List<HomeBase.DataBean.ActivityInfoBean.ActivityInfoListBean> activityInfoList = data.getActivityInfo().getActivityInfoList();
            activityInfoList.addAll(activityInfoList);
            myRemen.homeremenRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
            myRemen.homeremenRecyclerview.setAdapter(new RemenAdapter(context, activityInfoList));
        }else if(getItemViewType(position) == TY_Zhuanti ){//热门专题
            Zhuanti zhuanti = (Zhuanti) holder;
            String descImage = data.getSubjects().get(0).getDescImage();
            ImageLoader.getInstance().displayImage(descImage,zhuanti.homezhuantiImage);
            List<HomeBase.DataBean.SubjectsBean.GoodsListBeanX> goodsList = data.getSubjects().get(0).getGoodsList();
            zhuanti.homezhuantiRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
            zhuanti.homezhuantiRecyclerview.setAdapter(new ZhuantiAdapter(context, goodsList));
        }else if(getItemViewType(position) == TY_Meigui){//玫瑰
            Meigui meigui = (Meigui) holder;
            String descImage = data.getSubjects().get(1).getDescImage();
            ImageLoader.getInstance().displayImage(descImage,meigui.homemeiguiImage);
            List<HomeBase.DataBean.SubjectsBean.GoodsListBeanX> goodsList = data.getSubjects().get(1).getGoodsList();
            meigui.homemeiguiRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
            meigui.homemeiguiRecyclerview.setAdapter(new MeiguiAdapter(context, goodsList));
        }else{//猜你喜欢
            Xihuan xihuan = (Xihuan) holder;
            List<HomeBase.DataBean.SubjectsBean.GoodsListBeanX> goodsList = data.getSubjects().get(0).getGoodsList();
            xihuan.homexihuanRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
            xihuan.homexihuanRecyclerview.setAdapter(new XihuanAdapter(context, goodsList));
        }

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TY_Banner;
        } else if (position == 1) {
            return TY_Qiandao;
        } else if (position == 2) {
            return TY_Remen;
        } else if (position == 3) {
            return TY_Zhuanti;
        } else if (position == 4) {
            return TY_Meigui;
        } else {
            return TY_Xihuan;
        }
    }

    //Banner轮播图
    class MyBanner extends RecyclerView.ViewHolder {
        Banner homebannerBanner;
        public MyBanner(View itemView) {
            super(itemView);
            homebannerBanner = itemView.findViewById(R.id.homebanner_banner);
        }
    }

    //每日签到
    class MyQiandao extends RecyclerView.ViewHolder {
        RecyclerView homeqiandaoRecyclerview;
        public MyQiandao(View itemView) {
            super(itemView);
            homeqiandaoRecyclerview = itemView.findViewById(R.id.homeqiandao_recyclerview);
        }
    }
    //热门活动
    class MyRemen extends RecyclerView.ViewHolder{

        CountdownView homeremenDaojishi;
        RecyclerView homeremenRecyclerview;
        public MyRemen(View itemView) {
            super(itemView);
            homeremenRecyclerview = itemView.findViewById(R.id.homeremen_recyclerview);
            homeremenDaojishi = itemView.findViewById(R.id.homeremen_daojishi);
        }
    }
    //专题
    class Zhuanti extends RecyclerView.ViewHolder{
        ImageView homezhuantiImage;
        RecyclerView homezhuantiRecyclerview;
        public Zhuanti(View itemView) {
            super(itemView);
            homezhuantiRecyclerview = itemView.findViewById(R.id.homezhuanti_recyclerview);
            homezhuantiImage = itemView.findViewById(R.id.homezhuanti_image);
        }
    }
    //玫瑰
    class Meigui extends RecyclerView.ViewHolder{
        ImageView homemeiguiImage;
        RecyclerView homemeiguiRecyclerview;
        public Meigui(View itemView) {
            super(itemView);
            homemeiguiRecyclerview = itemView.findViewById(R.id.homemeigui_recyclerview);
            homemeiguiImage = itemView.findViewById(R.id.homemeigui_image);
        }
    }
    //猜你喜欢
    class Xihuan extends RecyclerView.ViewHolder{
        RecyclerView homexihuanRecyclerview;
        public Xihuan(View itemView) {
            super(itemView);
            homexihuanRecyclerview = itemView.findViewById(R.id.homexihuan_recyclerview);
        }
    }

}
