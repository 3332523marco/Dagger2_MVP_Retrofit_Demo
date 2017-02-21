package shengyuan.dagger2_mvp_retrofit_demo.moudle;

import dagger.Module;
import dagger.Provides;
import shengyuan.dagger2_mvp_retrofit_demo.MainActivity;
import shengyuan.dagger2_mvp_retrofit_demo.data.TestB;
import shengyuan.dagger2_mvp_retrofit_demo.data.User;
import shengyuan.dagger2_mvp_retrofit_demo.presenter.MainPresenter;
import shengyuan.dagger2_mvp_retrofit_demo.scope.ActivityScope;
import shengyuan.dagger2_mvp_retrofit_demo.scope.PoetryQualifier;

/**
 * Created by Marco on 17/2/14.
 */
@Module
public class MainModule {

    private MainActivity mainActivity;

    public MainModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


    @Provides
    @ActivityScope
    MainActivity provideMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    MainPresenter provideMainPresenter(@PoetryQualifier("A")User user) {
        return new MainPresenter(mainActivity, user);
    }

    @Provides
    @ActivityScope
    TestB provideTestB() {
        return new TestB();
    }
}
