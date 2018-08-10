package com.example.clp.sharedpreferencesutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.clp.sharedpreferencesutils.utils.LocalDataManager;
import com.example.clp.sharedpreferencesutils.utils.LogUtil;
import com.example.clp.sharedpreferencesutils.utils.PrefsHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化Prefs 建议在Application 中进行初始化
        PrefsHelper.init(this);


        UserBean mUserBean = new UserBean();
        mUserBean.setAll_money(1);
        LocalDataManager.getInstance().saveUserInfo(mUserBean);
        // 一般登录的时候，拿到用户的数据，直接保存在SP 中，或者APP 是否首次登录等判断

        UserBean bean  = LocalDataManager.getInstance().getUserInfo();
        LogUtil.e(bean.getAll_money()+"元");




    }
}
