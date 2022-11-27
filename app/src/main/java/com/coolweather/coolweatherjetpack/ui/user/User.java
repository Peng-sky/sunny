package com.coolweather.coolweatherjetpack.ui.user;

import java.io.Serializable;
import java.util.List;


public class User implements Serializable {

    private int id;
    private String name;
    private int state;

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
