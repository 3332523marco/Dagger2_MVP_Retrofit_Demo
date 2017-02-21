package shengyuan.dagger2_mvp_retrofit_demo;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import shengyuan.dagger2_mvp_retrofit_demo.component.MainAppComponent;
import shengyuan.dagger2_mvp_retrofit_demo.moudle.SecondModule;
import shengyuan.dagger2_mvp_retrofit_demo.presenter.SecondPresenter;

/**
 * Created by Marco on 17/2/15.
 */
public class SecondActivity extends BaseActivity {

    private final static String TAG = MainActivity.class.getSimpleName();


    @Inject
    SecondPresenter presenter;

    @InjectView(R.id.value_retrofit)
    TextView responseTxt;
    @InjectView(R.id.title)
    TextView titleTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_second);
        ButterKnife.inject(this);
        presenter.showTitle();
    }

    @Override
    protected void setupActivityComponent(MainAppComponent mainAppComponent) {
        mainAppComponent.plus(new SecondModule(this)).inject(this);
    }

    public void setTitleView(String title) {
        Log.i(TAG, "title " + title);
        titleTxt.setText(title);
    }

    public void setResponseView(String value) {
        Log.i(TAG, "value " + value);
        responseTxt.setText(value);
    }

    @OnClick(R.id.btn_retrofit)
    public void onClick() {
        presenter.loadNetService("square", "retrofit");
    }
}
