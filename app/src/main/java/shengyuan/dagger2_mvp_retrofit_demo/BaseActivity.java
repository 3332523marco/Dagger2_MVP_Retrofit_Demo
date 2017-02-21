package shengyuan.dagger2_mvp_retrofit_demo;

import android.app.Activity;
import android.os.Bundle;

import shengyuan.dagger2_mvp_retrofit_demo.component.MainAppComponent;

/**
 * Created by clevo on 2015/6/10.
 */
public abstract  class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(MainAppliaction.get(this).getMainAppComponent());
    }

    protected abstract  void setupActivityComponent(MainAppComponent mainAppComponent);
}
