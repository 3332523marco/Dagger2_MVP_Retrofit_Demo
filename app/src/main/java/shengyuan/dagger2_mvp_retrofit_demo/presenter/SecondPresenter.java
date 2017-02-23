package shengyuan.dagger2_mvp_retrofit_demo.presenter;

import android.util.Log;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import shengyuan.dagger2_mvp_retrofit_demo.SecondActivity;
import shengyuan.dagger2_mvp_retrofit_demo.api.response.Contributions;
import shengyuan.dagger2_mvp_retrofit_demo.api.service.NetApiService;
import shengyuan.dagger2_mvp_retrofit_demo.data.User;

/**
 * Created by Marco on 17/2/15.
 */
public class SecondPresenter {
    private static final String TAG = SecondPresenter.class.getSimpleName();
    private SecondActivity secondActivity;
    private NetApiService netApiService;
    private User user;

    public SecondPresenter(SecondActivity secondActivity,NetApiService netApiService, User user) {
        this.secondActivity = secondActivity;
        this.netApiService = netApiService;
        this.user = user;
    }

    public void showTitle(){
        secondActivity.setTitleView(user.getName());
    }


    public void loadNetService(String owner, String repo){
        netApiService.contributors(owner, repo, new Callback<List<Contributions>>() {
            @Override
            public void success(List<Contributions> tests, Response response) {
                Log.i(TAG, "tests " + response.getUrl());
                secondActivity.setResponseView("value size " + tests.size());
            }

            @Override
            public void failure(RetrofitError error) {
                secondActivity.setResponseView("retrofit fail ");
            }
        });
    }
}
