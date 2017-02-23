package shengyuan.dagger2_mvp_retrofit_demo.component;

import dagger.Component;
import shengyuan.dagger2_mvp_retrofit_demo.MainActivity;
import shengyuan.dagger2_mvp_retrofit_demo.moudle.MainModule;
import shengyuan.dagger2_mvp_retrofit_demo.scope.ActivityScope;

/**
 * Created by Marco on 17/2/14.
 */
@ActivityScope
@Component(modules = MainModule.class,dependencies = MainAppComponent.class)//dependencies 表示该 Component 提供的注入类的构造函数中，还依赖其他 @Component 提供的一些类。
public interface MainComponent {

    MainActivity inject(MainActivity mainActivity);//Dagger2会从目标类开始查找@Inject注解，自动生成依赖注入的代码，调用inject可完成依赖的注入。

}
