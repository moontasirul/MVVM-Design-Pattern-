package com.moontasirul.mvvm.mvvmpractice.viewModel;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.moontasirul.mvvm.mvvmpractice.callback.LoginResultCallBack;
import com.moontasirul.mvvm.mvvmpractice.model.UserModel;

import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    private UserModel userModel;

    private LoginResultCallBack loginResultCallBack;

    public LoginViewModel(LoginResultCallBack loginResultCallBack) {
        this.loginResultCallBack = loginResultCallBack;
        this.userModel = new UserModel();
    }


    public TextWatcher getEmailTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("checkWatcherEmail", "Start: "+start+", "+"before: "+before+","+"count: "+count);
            }

            @Override
            public void afterTextChanged(Editable s) {
                userModel.setEmailId(s.toString());
            }
        };
    }

    public TextWatcher getPasswordTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                userModel.setPassword(s.toString());
            }
        };
    }

    public void onLoginClicked(View view) {
        int errorCode = userModel.isValidData();
        if (errorCode == 0) {
            loginResultCallBack.onError("You must enter your Email address");
        } else if (errorCode == 1) {
            loginResultCallBack.onError("Your Email address is invalid");
        } else if (errorCode == 2) {
            loginResultCallBack.onError("You Password length must greater than 6 characters");
        } else {
            loginResultCallBack.onSuccess("Login Success");
        }
    }


}
