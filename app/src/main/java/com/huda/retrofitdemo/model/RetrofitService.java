package com.huda.retrofitdemo.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofit = builder.build();

    private static PostApi postApi = retrofit.create(PostApi.class);

    public static PostApi postApi(){
        return postApi;
    }
}
