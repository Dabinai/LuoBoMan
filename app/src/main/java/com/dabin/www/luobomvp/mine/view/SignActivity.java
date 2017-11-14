package com.dabin.www.luobomvp.mine.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.mine.presenter.PresenterSign;
import com.dabin.www.luobomvp.utils.ToastShow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignActivity extends AppCompatActivity implements IViewSign{

    @BindView(R.id.sign_title)
    TextView signTitle;
    @BindView(R.id.sign_username)
    EditText signUsername;
    @BindView(R.id.sign_password)
    EditText signPassword;
    @BindView(R.id.sign_arginpass)
    EditText signArginpass;
    @BindView(R.id.sign_email)
    EditText signEmail;
    @BindView(R.id.sign_btn)
    Button signBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.sign_btn)
    public void onViewClicked() {
        String signusername = signUsername.getText().toString();
        String signpassword = signPassword.getText().toString();
        String signarginpass = signArginpass.getText().toString();
        String signemail = signEmail.getText().toString();

        if("".equals(signusername)||"".equals(signpassword)||"".equals(signarginpass)||"".equals(signemail)){
            ToastShow.showLong(SignActivity.this,"信息不完整");
        }else{
            if(signpassword.equals(signarginpass)){
                new PresenterSign(this).setUrl(signusername,signpassword);
            }else{
                ToastShow.showLong(SignActivity.this,"两次密码不一致");
            }
        }

    }

    @Override
    public void signsuccess(String code) {
        if("0".equals(code)){
            startActivity(new Intent(SignActivity.this,LoginActivity.class));
        }else{
            ToastShow.showLong(SignActivity.this,"账号已注册");
        }
    }
}
