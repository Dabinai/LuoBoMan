package com.dabin.www.luobomvp.mine.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.mine.bean.UserBase;
import com.dabin.www.luobomvp.mine.presenter.PresenterLogin;
import com.dabin.www.luobomvp.utils.SharedPreferencesUtils;
import com.dabin.www.luobomvp.utils.ToastShow;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements IViewLogin{

    @BindView(R.id.login_username)
    EditText loginUsername;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.login_sign)
    TextView loginSign;
    @BindView(R.id.login_btn)
    Button loginBtn;
    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login_sign, R.id.login_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_sign:
                startActivity(new Intent(LoginActivity.this, SignActivity.class));
                break;
            case R.id.login_btn:
                username = loginUsername.getText().toString();
                password = loginPassword.getText().toString();

                if("".equals(username)||"".equals(password)){
                    ToastShow.showLong(LoginActivity.this,"信息不完成");
                }else{
                    new PresenterLogin(this).setLoginUrl(username,password);

                }
                break;
        }
    }

    @Override
    public void success(String code) {
        if("0".equals(code)){
            //发送消息  使用粘性
            EventBus.getDefault().postSticky(new UserBase(loginUsername.getText().toString(),loginPassword.getText().toString()));
            SharedPreferencesUtils.put(LoginActivity.this,"IsLogin",true);
          /*  startActivity(new Intent(LoginActivity.this,MessageActivity.class));*/
            finish();
        }else{
            ToastShow.showLong(LoginActivity.this,"账号或密码不正确");
        }
    }


}