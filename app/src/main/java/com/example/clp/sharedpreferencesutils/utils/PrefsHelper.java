package com.example.clp.sharedpreferencesutils.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.example.clp.sharedpreferencesutils.UserBean;
import com.google.gson.Gson;

/**
 * @author 大鹏
 * @since 1.0.0
 */
public class PrefsHelper {
    //保存文件名称
    private static final String PREFERENCE_FILE_NAME = "Example";
    //用户个人的信息
    private static final String KEY_USER_INFO = "UserInfo";

    // 注册
    public static void init(Context context) {
        Prefs.init(context.getApplicationContext(), PREFERENCE_FILE_NAME);
    }

    /**
     * 保存用户的登录数据。
     */
    public static void setUserInfo(@NonNull UserBean info) {
        String infoToSave = new Gson().toJson(info);
        LogUtil.d("UserBeanToSp:%s" + infoToSave);
        Prefs.set(KEY_USER_INFO, infoToSave);
    }

    /**
     * 获取用户的个人信息。
     */
    @Nullable
    public static UserBean getUserInfo() {
        String savedInfo = Prefs.getString(KEY_USER_INFO);
        if (TextUtils.isEmpty(savedInfo)) {
            return null;
        }
        return new Gson().fromJson(savedInfo, UserBean.class);
    }

    /**
     * 清除用户登录数据。
     */
    public static void removeLoginInfo() {
        LogUtil.d("Removing UserBean info.");
        Prefs.remove(KEY_USER_INFO);
    }
}
