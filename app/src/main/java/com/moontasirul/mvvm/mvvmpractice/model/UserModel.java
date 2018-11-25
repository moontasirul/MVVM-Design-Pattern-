package com.moontasirul.mvvm.mvvmpractice.model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;

public class UserModel extends BaseObservable {

    /**
     * user email id
     */
    @NonNull
    private String emailId;

    /**
     * user password
     */
    @NonNull
    private String password;


    public UserModel(){

    }

    public UserModel(@NonNull String emailId, @NonNull String password) {
        this.emailId = emailId;
        this.password = password;
    }


    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(@NonNull String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public int isValidData(){
        if(TextUtils.isEmpty(getEmailId())){
            return 0;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(getEmailId()).matches()){
            return 1;
        } else if(getPassword().length()<6){
            return 2;
        }else {
            return -1;
        }
    }
}
