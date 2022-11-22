package com.coolweather.coolweatherjetpack.ui.user;

import java.io.Serializable;
import java.util.List;


public class User implements Serializable {

    private int id;
    private boolean isLogin;
    private boolean hasPermission;
    private boolean superUser;

    public User(int id, boolean isLogin, boolean hasPermission, boolean superUser) {
        this.id = id;
        this.isLogin = isLogin;
        this.hasPermission = hasPermission;
        this.superUser = superUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public boolean hasPermission() {
        return hasPermission;
    }

    public void grantPermission(boolean hasPermission) {
        this.hasPermission = hasPermission;
    }

    public boolean superUser() {
        return superUser;
    }

    public void grantSuperUser(boolean superUser) {
        this.superUser = superUser;
    }
}
