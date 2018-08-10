package com.example.clp.sharedpreferencesutils.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.Map;

/**
 * 帮助类处理首选文件操作
 */
@SuppressWarnings("unused")
/* package */ class Prefs {
    private static Context appContext;
    private static String fileName;

    /**
     * 为后续调用初始化此类.
     * @param context 上下文.
     * @param file SP的文件读写.
     */
    public static void init(@NonNull Context context, @NonNull String file){
        appContext = context.getApplicationContext();
        fileName = file;
    }

    /**
     *检索SP值，假设第二个参数是正确的类.
     * @param <T> 支持类型Boolean, Integer, Long, Float, Double, String，不支持类型会抛出
     */
    @SuppressWarnings("unchecked")
    public static <T> T get(@NonNull String key, T fallback) throws
            UnsupportedOperationException {
        SharedPreferences sp = getSharedPreferences();
        Object result;
        if (fallback instanceof Boolean){
            result = sp.getBoolean(key, (Boolean)fallback);
        }
        else if (fallback instanceof String){
            result = sp.getString(key, (String) fallback);
        }
        else if (fallback instanceof Integer){
            result = sp.getInt(key, (Integer) fallback);
        }
        else if (fallback instanceof Float){
            result = sp.getFloat(key, (Float) fallback);
        }
        else if (fallback instanceof Long) {
            result = sp.getLong(key, (Long) fallback);
        }
        else{
            throw new UnsupportedOperationException("Type not supported: " + fallback.getClass()
                    .getSimpleName());
        }
        return (T)result;
    }

    /**
     * 从首选项中检索字符串值，默认值为空字符串。.
     */
    public static String getString(@NonNull String key){
        return get(key, "");
    }

    /**
     * 长值检索默认是 0 代码。
     */
    public static long getLong(@NonNull String key){
        return get(key, 0L);
    }

    /**
     * 从首选项中检索整数值, default is <code>0</code>.
     */
    public static int getInt(@NonNull String key){
        return get(key, 0);
    }

    /**
     * 检索一个布尔值, default is <code>false</code>.
     */
    public static boolean getBoolean(@NonNull String key){
        return get(key, false);
    }

    /**
     * 把值放进SP 中
     * @param <T> Boolean, Integer, Long, Float, Double, String allowed. For other types, an
     *           UnsupportedOperationException is thrown.
     */
    public static <T> void set(@NonNull String key, @NonNull T value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        if (value instanceof Boolean){
            editor.putBoolean(key, (Boolean) value);
        }
        else if (value instanceof String){
            editor.putString(key, (String) value);
        }
        else if (value instanceof Integer){
            editor.putInt(key, (Integer) value);
        }
        else if (value instanceof Float){
            editor.putFloat(key, (Float) value);
        }
        else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        }
        else{
            throw new UnsupportedOperationException("Type not supported: " + value.getClass()
                    .getSimpleName());
        }
        //use apply instead of commit to improve performance on UI thread.
        editor.apply();
    }

    public static void remove(String key) {
        getSharedPreferences().edit().remove(key).apply();
    }

    /**
     * clear all data!
     * @see SharedPreferences.Editor#clear()
     */
    public static void clear(){
        getSharedPreferences().edit().clear().apply();
    }

    private static SharedPreferences getSharedPreferences() {
        checkInitiatedOrThrow();
        return appContext.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    /**
     * Retrieve all values from the preferences.
     * @see SharedPreferences#getAll()
     */
    public static Map<String, ?> getAll(){
        return getSharedPreferences().getAll();
    }

    private static void checkInitiatedOrThrow() {
        if (appContext == null || TextUtils.isEmpty(fileName)) {
            throw new IllegalStateException("The Prefs class is not initialized correctly.");
        }
    }
}