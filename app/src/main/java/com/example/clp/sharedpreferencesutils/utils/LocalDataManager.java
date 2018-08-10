package com.example.clp.sharedpreferencesutils.utils;

import android.support.annotation.NonNull;

import com.example.clp.sharedpreferencesutils.UserBean;


/**
 * 管理本地数据的存储，抽象解耦非简单配置项的本地数据存储位置（File、DB、SP），例如用户信息。
 *
 * @author Muyangmin
 * @since 1.0.0
 */
public class LocalDataManager {

    private static LocalDataManager instance;
    private UserBean mUserBean;
    private LocalDataManager() {
        // 私有化构造
    }

    public static LocalDataManager getInstance() {
        if (instance == null) {
            synchronized (LocalDataManager.class) {
                // 线程安全的单利模式
                if (instance == null) {
                    instance = new LocalDataManager();
                }
            }
        }
        return instance;
    }

    /**
     * 获取用户个人信息
     *
     * @return
     */
    public UserBean getUserInfo() {
        if (mUserBean == null) {
            mUserBean = PrefsHelper.getUserInfo();
        }
        return mUserBean;
    }

    /**
     * 获取用户个人信息
     *
     * @return
     */
    public void saveUserInfo(@NonNull UserBean mUserBean) {
        //Update cached object!
        this.mUserBean = mUserBean;
        PrefsHelper.setUserInfo(mUserBean);
    }
    /**
     * 清楚用户信息
     *
     * @return
     */
    public void clearLoginInfo() {
        mUserBean = null;
        PrefsHelper.removeLoginInfo();
    }

}
