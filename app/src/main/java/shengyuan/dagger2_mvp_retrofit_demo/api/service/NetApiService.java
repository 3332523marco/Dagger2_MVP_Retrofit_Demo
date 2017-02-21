package shengyuan.dagger2_mvp_retrofit_demo.api.service;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import shengyuan.dagger2_mvp_retrofit_demo.api.response.Contributions;

/**
 * Created by Marco on 17/2/20.
 */
public interface NetApiService {

    @GET("/repos/{owner}/{repo}/contributors")
    void contributors(@Path("owner") String owner, @Path("repo") String repo, Callback<List<Contributions>> callback);
}
