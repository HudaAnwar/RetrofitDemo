package com.huda.retrofitdemo.repository;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.huda.retrofitdemo.model.Post;
import com.huda.retrofitdemo.model.RetrofitService;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    public static MutableLiveData<Post> postMutableLiveData =
            new MutableLiveData<>();
    public static MutableLiveData<String> errorMsg =
            new MutableLiveData<>();
    public static MutableLiveData<Boolean> isNull =
            new MutableLiveData<>();

    public static void getPost(int id) {

        Call<List<Post>> call =
                RetrofitService
                        .postApi()
                        .getPost(String.valueOf(id));
        call.enqueue(new Callback<List<Post>>() {

            @Override
            public void onResponse(@NotNull Call<List<Post>> call,
                                   @NotNull Response<List<Post>> response) {
                Log.v("DEBUG : ", response.body().toString());

                List<Post> post = response.body();
                if (post.size() > 0) {
                    postMutableLiveData.setValue(post.get(0));
                } else {
                    isNull.setValue(true);
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Post>> call,
                                  @NotNull Throwable t) {
                Log.v("DEBUG : ", t.getMessage());
                errorMsg.setValue(t.getMessage());
            }
        });

    }

}
