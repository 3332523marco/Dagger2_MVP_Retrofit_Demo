package shengyuan.dagger2_mvp_retrofit_demo.moudle;

import dagger.Module;
import dagger.Provides;
import shengyuan.dagger2_mvp_retrofit_demo.SecondActivity;
import shengyuan.dagger2_mvp_retrofit_demo.api.service.NetApiService;
import shengyuan.dagger2_mvp_retrofit_demo.data.User;
import shengyuan.dagger2_mvp_retrofit_demo.presenter.SecondPresenter;
import shengyuan.dagger2_mvp_retrofit_demo.scope.PoetryQualifier;
import shengyuan.dagger2_mvp_retrofit_demo.scope.SecondScope;

/**
 * Created by Marco on 17/2/15.
 */
@Module
public class SecondModule {
    private SecondActivity secondActivity;

    public SecondModule(SecondActivity secondActivity) {
        this.secondActivity = secondActivity;
    }


    @Provides
    @SecondScope
    SecondActivity provideSecondActivity() {
        return secondActivity;
    }


    @Provides
    @SecondScope
    SecondPresenter provideSecondPresenter(@PoetryQualifier("B") User user,NetApiService netApiService) {
        return new SecondPresenter(secondActivity, netApiService,user);
    }
}
