package com.coolweather.coolweatherjetpack.ui.user;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.ArraySet;

import androidx.annotation.RequiresApi;

import com.coolweather.coolweatherjetpack.CoolWeatherApplication;

import java.util.Random;

@RequiresApi(api = Build.VERSION_CODES.M)

public class UserManager {
    private ArraySet<Integer> userIds = new ArraySet<>();
    Random random = new Random();
    private static UserManager sInstance;
    public static final String USER_ID = "user_id";
    SharedPreferences sharedPreferences;

    private boolean isLogin = false;
    private boolean hasPermission = false;
    private boolean isSuperUser = false;

    private UserManager() {
        sharedPreferences = CoolWeatherApplication.context.getSharedPreferences("users", Context.MODE_PRIVATE);
    }

    public void registerUserIds(int id) {
        int i = random.nextInt();
        userIds.add(random.nextInt());
        sharedPreferences.edit().putInt(USER_ID, i).apply();
    }

    public UserManager getInstance() {
        if (sInstance == null) {
            sInstance = new UserManager();
        }
        return sInstance;
    }

    public void getUserById(int id) {

    }
}
