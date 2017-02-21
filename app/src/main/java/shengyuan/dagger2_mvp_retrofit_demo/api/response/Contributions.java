package shengyuan.dagger2_mvp_retrofit_demo.api.response;

/**
 * Created by Marco on 17/2/20.
 */
public class Contributions {
    String login;
    int contributions;

    @Override
    public String toString() {
        return login + ", " + contributions;
    }
}
