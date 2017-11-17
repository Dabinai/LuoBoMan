package com.dabin.www.luobomvp.kind.model;

import com.dabin.www.luobomvp.kind.bean.OneBase;
import com.dabin.www.luobomvp.kind.bean.ThreeBase;
import com.dabin.www.luobomvp.kind.bean.TwoBase;
import com.dabin.www.luobomvp.utils.RetroFactoryKind;

import java.util.HashMap;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Dabin on 2017/11/13.
 */

public class ModelOne implements IModelOne{

    private List<OneBase.DatasBean.ClassListBean> class_list;
    private  List<TwoBase.DatasBean.ClassListBean> class_listtwo;
    private List<ThreeBase.DatasBean.ClassListBean> class_listthree;





    //第三个分类
    private OnThreeFinish onThreeFinish;

    public interface OnThreeFinish{
        void ThreeFinish( List<ThreeBase.DatasBean.ClassListBean> class_listthree);
    }
    public void setOnThreeFinish(OnThreeFinish onThreeFinish){
        this.onThreeFinish = onThreeFinish;
    }

    //第二个分类
    private OnTwoFinish onTwoFinish;

    public interface OnTwoFinish{
        void TwoFinish( List<TwoBase.DatasBean.ClassListBean> class_listtwo);
    }
    public void setOnTwoFinish(OnTwoFinish onTwoFinish){
        this.onTwoFinish = onTwoFinish;
    }



    //第一个分类
    private OnOneFinish onOneFinish;

    public interface OnOneFinish{
        void OneFinish(List<OneBase.DatasBean.ClassListBean> class_list);
    }

    public void setOnOneFinish(OnOneFinish onOneFinish){
        this.onOneFinish = onOneFinish;
    }
    //第一个分类网络请求
    @Override
    public void getUrl(String url) {
        RetroFactoryKind.getInstance().getOnes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OneBase>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(OneBase oneBase) {
                        class_list = oneBase.getDatas().getClass_list();
                        onOneFinish.OneFinish(class_list);
                    }
                });
    }
    //第二个分类网络请求
    @Override
    public void getUrlTwo(String gc_id) {
        HashMap map = new HashMap<String,String>();
        map.put("gc_id",gc_id);
        RetroFactoryKind.getInstance().getTwos("mobile/index.php?act=goods_class",map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TwoBase>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TwoBase twoBase) {
                        class_listtwo = twoBase.getDatas().getClass_list();
                        onTwoFinish.TwoFinish(class_listtwo);
                    }
                });
    }



    //第三个分类网络请求
    public void getUrlThree(String gc_id) {
        HashMap map = new HashMap<String,String>();
        map.put("gc_id",gc_id);
        RetroFactoryKind.getInstance().getThrees("mobile/index.php?act=goods_class",map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ThreeBase>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ThreeBase threeBase) {
                        class_listthree = threeBase.getDatas().getClass_list();
                        onThreeFinish.ThreeFinish(class_listthree);
                    }
                });
    }


}
