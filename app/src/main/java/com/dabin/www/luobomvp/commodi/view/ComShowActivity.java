package com.dabin.www.luobomvp.commodi.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.TextView;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.commodi.bean.ComShowBase;
import com.dabin.www.luobomvp.common.PlayerManager;
import com.dabin.www.luobomvp.widget.media.IjkVideoView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComShowActivity extends AppCompatActivity implements PlayerManager.PlayerStateListener{


    @BindView(R.id.comshow_bargainPrice)
    TextView comshowBargainPrice;
    @BindView(R.id.comshow_price)
    TextView comshowPrice;
    @BindView(R.id.comshow_subhead)
    TextView comshowSubhead;
    @BindView(R.id.comshow_title)
    TextView comshowTitle;
    @BindView(R.id.video_view)
    IjkVideoView videoView;
    private String url4 = "http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4";
    private PlayerManager player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_show);
        ButterKnife.bind(this);

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        initPlayer();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void OnComShow(ComShowBase comShowBase) {
        comshowTitle.setText(comShowBase.getData().get(0).getTitle());
        comshowBargainPrice.setText(comShowBase.getData().get(0).getBargainPrice() + "");
        comshowPrice.setText(comShowBase.getData().get(0).getPrice() + "");
        comshowSubhead.setText(comShowBase.getData().get(0).getSubhead());


    }

    private void initPlayer() {

        //初始化播放器
        player = new PlayerManager(this);
        player.setFullScreenOnly(true);
        player.setScaleType(PlayerManager.SCALETYPE_FILLPARENT);
        player.playInFullScreen(true);
        player.setPlayerStateListener(this);
        player.play(url4);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (player.gestureDetector.onTouchEvent(event))
            return true;
        return super.onTouchEvent(event);
    }


    @Override
    public void onComplete() {

    }

    @Override
    protected void onStop() {
        super.onStop();
        player.stop();
    }

    @Override
    public void onError() {
    }

    @Override
    public void onLoading() {
    }

    @Override
    public void onPlay() {
    }
}
