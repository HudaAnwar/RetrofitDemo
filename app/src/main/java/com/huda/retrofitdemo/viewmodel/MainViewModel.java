package com.huda.retrofitdemo.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.huda.retrofitdemo.model.Post;
import com.huda.retrofitdemo.repository.Repository;

public class MainViewModel extends ViewModel {
    public MutableLiveData<Post> postMutableLiveData;
    public MutableLiveData<String> errorMsg;
    public MutableLiveData<Boolean> isNull;

    public MainViewModel() {
        postMutableLiveData = Repository.postMutableLiveData;
        errorMsg = Repository.errorMsg;
        isNull = Repository.isNull;
    }

    public void getPost(int id) {
        Repository.getPost(id);
    }


}
