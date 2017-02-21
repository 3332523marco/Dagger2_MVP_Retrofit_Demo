package shengyuan.dagger2_mvp_retrofit_demo.component;

import dagger.Subcomponent;
import shengyuan.dagger2_mvp_retrofit_demo.SecondActivity;
import shengyuan.dagger2_mvp_retrofit_demo.moudle.SecondModule;
import shengyuan.dagger2_mvp_retrofit_demo.presenter.SecondPresenter;
import shengyuan.dagger2_mvp_retrofit_demo.scope.SecondScope;

/**
 * Created by Marco on 17/2/15.
 */
@SecondScope //作用域   等同于singletan,但是有点区别是通过自定义Scope注解可以更好的管理创建的类实例的生命周期。不被外部调用
@Subcomponent(modules = SecondModule.class)
public interface SecondComponent {

    void inject(SecondActivity secondActivity); // 父 Component 不能注入容器，子 Component 一起注入

    SecondPresenter presenter();

}