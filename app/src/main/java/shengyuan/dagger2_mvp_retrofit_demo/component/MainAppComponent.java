package shengyuan.dagger2_mvp_retrofit_demo.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import shengyuan.dagger2_mvp_retrofit_demo.data.User;
import shengyuan.dagger2_mvp_retrofit_demo.moudle.MainAppModule;
import shengyuan.dagger2_mvp_retrofit_demo.moudle.NetServiceModule;
import shengyuan.dagger2_mvp_retrofit_demo.moudle.SecondModule;
import shengyuan.dagger2_mvp_retrofit_demo.scope.PoetryQualifier;

/**
 * Created by Marco on 17/2/14.
 */
@Singleton
@Component(modules = {MainAppModule.class,NetServiceModule.class})
public interface MainAppComponent {
    Application getApplication();

    @PoetryQualifier("A") // @Named是Dagger2对于@Qualifier一个默认实现，我们也可以自定义
    User getUser();

    @PoetryQualifier("B")
    User getSecondUser();

//    TestC t();

//    NetApiService getNetApiService();

    SecondComponent plus(SecondModule secondModule); // 声明子 Component 的获取方法，返回类型是 Subcomponent 类，方法名随意，参数是这个 Subcomponent 需要的 Modules，如 Modules 不用传参，可省略
}
