package com.daohen.social.wb.library.api;

import com.daohen.personal.toolbox.library.Singleton;
import com.daohen.social.wb.library.bean.SuccessObj;
import com.daohen.social.wb.library.bean.WbUserInfoResponse;
import com.daohen.social.wb.library.callback.LoginAuthListener;
import com.daohen.thirdparty.library.retrofit.RetrofitFactory;
import com.daohen.thirdparty.library.rxjava.SingleDefaultObserver;
import com.daohen.thirdparty.library.rxjava.SingleSchedulerTransformer;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;

import io.reactivex.annotations.NonNull;

/**
 * CREATE BY ALUN
 * EMAIL: alunfeixue2011@gmail.com
 * DATE : 2017/08/01 16:02
 */

public class WbApi {

    public static WbApi get(){
        return gDefault.get();
    }

    public void getUserInfo(Oauth2AccessToken accessToken, final LoginAuthListener listener){
        wbService.getUserInfo(accessToken.getToken(), accessToken.getUid())
                .compose(new SingleSchedulerTransformer<WbUserInfoResponse>())
                .subscribe(new SingleDefaultObserver<WbUserInfoResponse>() {
                    @Override
                    public void onSuccess(@NonNull WbUserInfoResponse wbUserInfoResponse) {
                        if (listener != null)
                            listener.onSuccess(new SuccessObj(wbUserInfoResponse));
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        if (listener != null)
                            listener.onFailure();
                    }
                });
    }

    private WbService wbService;

    private WbApi(){
        wbService = RetrofitFactory.getDefault("https://api.weibo.com/2/users/show.json")
                .create(WbService.class);
    }

    private static final Singleton<WbApi> gDefault = new Singleton<WbApi>() {
        @Override
        protected WbApi create() {
            return new WbApi();
        }
    };
}
