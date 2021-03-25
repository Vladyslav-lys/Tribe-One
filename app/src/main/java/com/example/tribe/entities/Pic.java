package com.example.tribe.entities;

import java.util.Date;

public class Pic {
    private String title;
    private String name;
    private int flagRes;
    private int flagPics;

    public Pic(String title, String name, int flagRes, int flagPics) {
        this.title = title;
        this.name = name;
        this.flagRes = flagRes;
        this.flagPics = flagPics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlagRes() {
        return flagRes;
    }

    public void setFlagRes(int flagRes) {
        this.flagRes = flagRes;
    }

    public int getFlagPics() { return flagPics; }

    public void setFlagPics(int flagPics) { this.flagPics = flagPics; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }
}
