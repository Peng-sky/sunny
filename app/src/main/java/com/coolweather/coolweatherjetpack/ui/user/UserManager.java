package com.coolweather.coolweatherjetpack.ui.user;

import android.widget.Toast;

import com.coolweather.coolweatherjetpack.CoolWeatherApplication;

public class UserManager {
    private static UserManager sInstance;

    public static final int LOGOUT = 0;
    public static final int LOGIN = 1;
    public static final int LOGIN_SUPER = 2;

    private UserManager() {
    }

    public static UserManager getInstance() {
        if (sInstance == null) {
            sInstance = new UserManager();
        }
        return sInstance;
    }

    public void login(User user, boolean superUser) {
        user.setState(LOGIN);
        if (superUser) {
            grantSuperUserPermission(user);
        }
    }

    public void logout(User user) {
        user.setState(LOGOUT);
    }

    private void grantSuperUserPermission(User user) {
        user.setState(LOGIN_SUPER);
    }

    public void accessData(User user) {
        if (user.getState() == LOGIN) {
            Toast.makeText(CoolWeatherApplication.context, "access data success", Toast.LENGTH_SHORT).show();
        } else if (user.getState() == LOGOUT) {
            Toast.makeText(CoolWeatherApplication.context, "user not login", Toast.LENGTH_SHORT).show();
        }
    }

    public void changeData(User user) {
        if (user.getState() == LOGIN) {
            Toast.makeText(CoolWeatherApplication.context, "no permission to change data", Toast.LENGTH_SHORT).show();
        } else if (user.getState() == LOGOUT) {
            Toast.makeText(CoolWeatherApplication.context, "user not login", Toast.LENGTH_SHORT).show();
        } else if (user.getState() == LOGIN_SUPER) {
            Toast.makeText(CoolWeatherApplication.context, "change data success", Toast.LENGTH_SHORT).show();
        }
    }
}
