package com.huda.retrofitdemo.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PostApi {
    @GET("/posts")
    Call<List<Post>> getPost(@Query("id") String id);
}
