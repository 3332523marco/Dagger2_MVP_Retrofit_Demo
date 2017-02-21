package shengyuan.dagger2_mvp_retrofit_demo.moudle;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import shengyuan.dagger2_mvp_retrofit_demo.data.User;
import shengyuan.dagger2_mvp_retrofit_demo.scope.PoetryQualifier;

/**
 * Created by Marco on 17/2/14.
 */
@Module
public class MainAppModule {
    private Application application;

    public MainAppModule(Application application){
        this.application=application;
    }

    @Provides
    @Singleton
    public Application provideApplication(){
        return application;
    }

    @PoetryQualifier("A")
    @Provides
    User provideUser() {
        User user = new User();
        user.setId("1");
        user.setName("hello,I'm Main");
        return user;
    }

    @PoetryQualifier("B")
    @Provides
    User provideSecondUser() {
        User user = new User();
        user.setId("2");
        user.setName("hello,I'm Second");
        return user;
    }

//    @Provides
//    TestC provideTestC() {
//        return new TestC();
//    }
}
