package com.huda.retrofitdemo.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.huda.retrofitdemo.databinding.ActivityMainBinding;
import com.huda.retrofitdemo.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.getPostBtn.setOnClickListener(v -> {
            viewModel.getPost(101);
        });
        viewModel.postMutableLiveData.observe(this, post -> {
            binding.titleTv.setText(post.getTitle());
            binding.bodyTv.setText(post.getBody());
        });
        viewModel.errorMsg.observe(this, error -> {
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        });
        viewModel.isNull.observe(this, isNull -> {
            Toast.makeText(this, "This Post is no longer exist",
                    Toast.LENGTH_SHORT).show();
        });
    }
}