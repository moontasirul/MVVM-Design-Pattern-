package com.moontasirul.mvvm.mvvmpractice.viewModel;

import com.moontasirul.mvvm.mvvmpractice.callback.LoginResultCallBack;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private LoginResultCallBack loginResultCallBack;

    public LoginViewModelFactory(LoginResultCallBack loginResultCallBack) {
        this.loginResultCallBack = loginResultCallBack;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LoginViewModel(loginResultCallBack);
    }
}
