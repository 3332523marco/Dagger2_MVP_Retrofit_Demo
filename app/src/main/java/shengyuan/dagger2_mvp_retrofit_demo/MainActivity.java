package shengyuan.dagger2_mvp_retrofit_demo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import shengyuan.dagger2_mvp_retrofit_demo.component.DaggerMainComponent;
import shengyuan.dagger2_mvp_retrofit_demo.component.MainAppComponent;
import shengyuan.dagger2_mvp_retrofit_demo.data.TestA;
import shengyuan.dagger2_mvp_retrofit_demo.data.TestB;
import shengyuan.dagger2_mvp_retrofit_demo.moudle.MainModule;
import shengyuan.dagger2_mvp_retrofit_demo.presenter.MainPresenter;


public class MainActivity extends BaseActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    @InjectView(R.id.title)
    TextView mTitleTxt;
    @InjectView(R.id.testa_inject)
    TextView testAInjectTxt;
    @InjectView(R.id.testb_inject)
    TextView testBInjectTxt;

    @Inject
    MainPresenter presenter;
    @Inject
    TestA testA;//  前缀一定要大写，不然无法实现注入
    @Inject
    TestB testB;

    //@Inject
    //NetApiService netApiService;    如果是dependencies = MainAppComponent.class   那么在MainActivity中调用MainAppModule中的实例对象，必须在MainAppComponent中写获取其的方法（可任意命名） 否则会报错
    //@Inject
    //NetApiService netApiService;   为什么NetApiService这个对象在NetServiceModule里实例化，NetServiceModule属于MainAppComponent  而MainComponent又依赖于MainAppComponent  却不能直接@Inject NetApiService对象呢
    //但是在SecondActivity里直接@Inject NetApiService对象却可以，
    // 这是因为SecondComponent是MainAppComponent的子Component  可以获取MainAppComponent的方法 对象  不需要你在其对应的Component中写获取方法，而如果是dependencies方法，则需要在对应的Component中写获取方法

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        presenter.showTitle();
        testAInjectTxt.setText(testA.toString());
        testBInjectTxt.setText(testB.toString());
    }

    @Override
    protected void setupActivityComponent(MainAppComponent mainAppComponent) {
        DaggerMainComponent.builder()
                .mainAppComponent(mainAppComponent) //因为要用到appComponent来setUser信息，所以需.appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    public void setTitleView(String title) {
        Log.i(TAG, "title " + title);
        mTitleTxt.setText(title);
    }

    @OnClick(R.id.tosecond)
    public void onClick() {
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }
}
