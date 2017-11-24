package com.dabin.www.luobomvp.shop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.shop.bean.Shopbase;
import com.dabin.www.luobomvp.utils.ToastShow;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Dabin on 2017/11/15.
 */

public class ExpandAdapter extends BaseExpandableListAdapter {

    private Context context;
    private Shopbase shopbase;

    public ExpandAdapter(Context context, Shopbase shopbase) {
        this.context = context;
        this.shopbase = shopbase;
    }

    public interface onAllClickListener{
        void onDownClick(int groupId,int childId);
        void onUpClick(int groupId,int childId);
        void onComplete(int groupId,int childId);
        void onChangeClick(int groupId,int childId);
        void onParentClick(int groupId);
    }
    private onAllClickListener mOnAllClickListener;
    public void setmOnAllClickListener(onAllClickListener mOnAllClickListener){
        this.mOnAllClickListener = mOnAllClickListener;
    }




    @Override
    public int getGroupCount() {
        return shopbase.getData().size();
    }

    @Override
    public int getChildrenCount(int i) {
        return shopbase.getData().get(i).getList().size();
    }

    @Override
    public Object getGroup(int i) {
        return shopbase.getData().get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return shopbase.getData().get(i).getList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    //先放着
    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int i, boolean b, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.shopone_item,null);
        }

        CheckBox oneCheck = view.findViewById(R.id.shopone_check);
        oneCheck.setChecked(shopbase.getData().get(i).isSelected());
        TextView oneName = view.findViewById(R.id.shopone_name);
        oneName.setText(shopbase.getData().get(i).getSellerName());
        //父类选中
        oneCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnAllClickListener.onParentClick(i);
            }
        });

        return view;
    }

    @Override
    public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.shoptwo_item,null);
        }

        CheckBox twoCheck = view.findViewById(R.id.shoptwo_check);  //选择框
        SimpleDraweeView twoImage = view.findViewById(R.id.shoptwo_image);
        Button twoDown = view.findViewById(R.id.shoptwo_down); // 减少
        Button twoUp = view.findViewById(R.id.shoptwo_up);  //添加
        Button complete = view.findViewById(R.id.shoptwo_complete);  //完成
        final TextView twoNum = view.findViewById(R.id.shoptwo_num); //数量
        TextView twoName = view.findViewById(R.id.shoptwo_name);
        TextView twoPrice = view.findViewById(R.id.shoptwo_price);

        //图片
        String images = shopbase.getData().get(i).getList().get(i1).getImages();
        String[] split = images.split("[|]");
        twoImage.setImageURI(split[0].toString());
        //数量
        final int num = shopbase.getData().get(i).getList().get(i1).getNum();
        //赋值
        String selected = shopbase.getData().get(i).getList().get(i1).getSelected();
        if("1".equals(selected)){
            twoCheck.setChecked(true);
        }else {
            twoCheck.setChecked(false);
        }
        twoNum.setText(num+"");
        twoName.setText(shopbase.getData().get(i).getList().get(i1).getTitle());
        twoPrice.setText("￥"+shopbase.getData().get(i).getList().get(i1).getPrice());

        if(mOnAllClickListener == null){
            ToastShow.showLong(context,"接口不能为空");
        }else{
            //减少
            twoDown.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(num == 1){
                        ToastShow.showLong(context,"不能再少了，亲！");
                    }else{
                        mOnAllClickListener.onDownClick(i,i1);
                    }
                }
            });
            //添加
            twoUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnAllClickListener.onUpClick(i,i1);
                }
            });
            complete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnAllClickListener.onComplete(i,i1);
                }
            });
            //子类选中
            twoCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnAllClickListener.onChangeClick(i,i1);
                }
            });


        }

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
