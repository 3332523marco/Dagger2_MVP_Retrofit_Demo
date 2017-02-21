package shengyuan.dagger2_mvp_retrofit_demo.presenter;

import shengyuan.dagger2_mvp_retrofit_demo.MainActivity;
import shengyuan.dagger2_mvp_retrofit_demo.data.User;

/**
 * Created by Marco on 17/2/14.
 */
public class MainPresenter {
    private MainActivity mainActivity;
    private User user;

    public MainPresenter(MainActivity mainActivity, User user) {
        this.mainActivity = mainActivity;
        this.user = user;
    }


    public void showTitle(){
        mainActivity.setTitleView(user.getName());
    }

}
