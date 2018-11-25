package com.moontasirul.mvvm.mvvmpractice.callback;

public interface LoginResultCallBack {
    void onSuccess(String message);
    void onError(String message);
}
