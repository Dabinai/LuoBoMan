package com.dabin.www.luobomvp.mine.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.mine.bean.MessBase;
import com.dabin.www.luobomvp.mine.presenter.PresenterMess;
import com.dabin.www.luobomvp.utils.SharedPreferencesUtils;
import com.dabin.www.luobomvp.utils.ToastShow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageActivity extends AppCompatActivity implements IViewMess{

    @BindView(R.id.message_name)
    TextView messageName; //UId
    @BindView(R.id.message_time)
    TextView messageTime;   //时间
    @BindView(R.id.message_gener)
    TextView messageGener; //Token
    @BindView(R.id.message_logout)
    Button messageLogout;   //注册


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        int uid = (int) SharedPreferencesUtils.get(MessageActivity.this,"UID",0);
        new PresenterMess(this).setUrl(uid+"");
    }

    //注销
    @OnClick(R.id.message_logout)
    public void onViewClicked() {
        SharedPreferencesUtils.put(MessageActivity.this,"IsLogin",false);
        SharedPreferencesUtils.put(MessageActivity.this,"UID",-1);
        startActivity(new Intent(MessageActivity.this,LoginActivity.class));
        finish();
    }

    @Override
    public void success(MessBase.DataBean data) {
        ToastShow.showLong(MessageActivity.this,data.getCreatetime());
        messageName.setText(data.getUid()+"");
        messageTime.setText(data.getCreatetime().toString());
        messageGener.setText(data.getToken().toString());
    }


}
