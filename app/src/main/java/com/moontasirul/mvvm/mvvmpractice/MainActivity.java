package com.moontasirul.mvvm.mvvmpractice;

import android.os.Bundle;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;

import com.moontasirul.mvvm.mvvmpractice.callback.LoginResultCallBack;
import com.moontasirul.mvvm.mvvmpractice.databinding.ActivityMainBinding;
import com.moontasirul.mvvm.mvvmpractice.viewModel.LoginViewModel;
import com.moontasirul.mvvm.mvvmpractice.viewModel.LoginViewModelFactory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity implements LoginResultCallBack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(ViewModelProviders.of(this, new LoginViewModelFactory(this))
        .get(LoginViewModel.class));
    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
