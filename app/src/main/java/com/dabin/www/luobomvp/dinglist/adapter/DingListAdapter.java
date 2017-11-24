package com.dabin.www.luobomvp.dinglist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.dinglist.bean.DingListBase;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * Created by Dabin on 2017/11/22.
 */

public class DingListAdapter extends XRecyclerView.Adapter<DingListAdapter.MyViewHolder>{

    private Context context;
    private DingListBase dingListBase;

    private OnItemClickon onItemClickon;

    public interface OnItemClickon{
        void ItemClickon(View v,int position);
    }

    public void setOnItemClickon(OnItemClickon onItemClickon){
        this.onItemClickon = onItemClickon;
    }

    public DingListAdapter(Context context, DingListBase dingListBase) {
        this.context = context;
        this.dingListBase = dingListBase;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.dinglist_item, parent, false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.createtime.setText("创建时间："+dingListBase.getData().get(position).getCreatetime());
        holder.orderid.setText("订单编号："+dingListBase.getData().get(position).getOrderid()+"");
        holder.price.setText("总价钱："+dingListBase.getData().get(position).getPrice()+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickon.ItemClickon(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dingListBase.getData().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView createtime;
        TextView orderid;
        TextView price;
        public MyViewHolder(View itemView) {
            super(itemView);
            createtime = itemView.findViewById(R.id.dinglist_item_time);
            orderid = itemView.findViewById(R.id.dinglist_item_orderid);
            price = itemView.findViewById(R.id.dinglist_item_price);
        }
    }
}
